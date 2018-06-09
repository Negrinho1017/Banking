package co.com.banking.infrastructure.persistence.repository

import co.com.banking.domain.entities.account.Account
import co.com.banking.domain.entities.client.Client
import co.com.banking.infrastructure.builders.AccountBuilder
import co.com.banking.infrastructure.persistence.dao.{AccountDAO, BankMovementsDAO}
import co.com.banking.infrastructure.persistence.dto.{AccountDto, BankMovementsDto}
import domain.exceptions.ModelErrors
import javax.inject.Inject

import scala.concurrent.{ExecutionContext, Future}
import scala.util.Try

class AccountRepository @Inject()(
accountDAO: AccountDAO,
bankMovementsDAO: BankMovementsDAO,
accountBuilder: AccountBuilder
)(implicit executionContext: ExecutionContext){


  def saveConsigAccount(account: Account, client: Client): Account={
    //llamamamos los dao y persistimos la información

    //devuelve la cuenta con los datos actualizados
    account:Account
  }

  def getAccountById(accountId:String)= {
    for {
      account <- accountDAO.findByAccountNumber(accountId)
    } yield {
      account.map(acc => accountBuilder.convertFromDtoToDomain(acc))
    }
  }

  //recibimos los datos necesarios para guardar el movimiento
  //def saveMovement(accountOrigin: Account, accountDestination: Account, typeMov: String, ammount:Double) ={
    //val movementDTO = BankMovementsDto.apply("djfsf343", typeMov, accountOrigin, accountDestination, ammount)
    //bankMovementsDAO.insertNewMovement()
 // }

}
