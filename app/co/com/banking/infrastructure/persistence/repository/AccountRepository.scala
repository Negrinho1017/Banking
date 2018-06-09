package co.com.banking.infrastructure.persistence.repository

import co.com.banking.domain.entities.account.Account
import co.com.banking.infrastructure.builders.AccountBuilder
import co.com.banking.infrastructure.persistence.dao.{AccountDAO, BankMovementsDAO}
import co.com.banking.infrastructure.persistence.dto.{AccountDto, BankMovementsDto}
import javax.inject.Inject

import scala.concurrent.{ExecutionContext, Future}

class AccountRepository @Inject()(
  accountDAO: AccountDAO,
  bankMovementsDAO: BankMovementsDAO,
  accountBuilder: AccountBuilder
  )(implicit executionContext: ExecutionContext){

  def getAccountById(accountId:String)= {
    for {
      account <- accountDAO.findByAccountNumber(accountId)
    } yield {
      account.map(acc => accountBuilder.convertFromDtoToDomain(acc))
    }
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
