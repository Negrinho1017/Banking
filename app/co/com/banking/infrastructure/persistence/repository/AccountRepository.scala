package co.com.banking.infrastructure.persistence.repository

import cats.data.{EitherT, OptionT}
import co.com.banking.domain.entities.account.Account
import co.com.banking.infrastructure.builders.AccountBuilder
import co.com.banking.infrastructure.persistence.dao.{AccountDAO, BankMovementsDAO}
import co.com.banking.infrastructure.persistence.dto.{AccountDto, BankMovementsDto}
import domain.exceptions.{AccountNotFound, ModelErrors}
import javax.inject.Inject

import scala.concurrent.{ExecutionContext, Future}

class AccountRepository @Inject()(
  accountDAO: AccountDAO,
  bankMovementsDAO: BankMovementsDAO,
  accountBuilder: AccountBuilder
  )(implicit executionContext: ExecutionContext){

  def getAccountById(accountId:String): Future[Either[ModelErrors, Account]] = {
    (for {
      account <- OptionT(accountDAO.findByAccountNumber(accountId)).toRight(AccountNotFound())
      acc     <- EitherT.fromEither[Future](accountBuilder.convertFromDtoToDomain(account))
    } yield {
      acc
    }).value
  }

  def saveMovement(accountOrigin: Account, accountDestination: Account, typeMov: String, value:BigDecimal) ={
    val movementDTO = BankMovementsDto.apply(
      "1",
      Option(typeMov),
      Option(accountOrigin.accountNumber.number.toString),
      Option(accountDestination.accountNumber.number.toString),
      Option(value.doubleValue()))
    bankMovementsDAO.insertNewMovement(movementDTO)
  }

}
