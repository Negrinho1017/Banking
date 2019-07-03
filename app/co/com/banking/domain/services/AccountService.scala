package model.services

import co.com.banking.domain.entities.account.{Account, Balance}
import co.com.banking.domain.entities.client.Client
import co.com.banking.infrastructure.builders.AccountBuilder
import co.com.banking.infrastructure.persistence.dao.{AccountDAO, BankMovementsDAO}
import co.com.banking.infrastructure.persistence.dto.BankMovementsDto
import co.com.banking.infrastructure.persistence.repository.AccountRepository
import javax.inject.Inject


import scala.concurrent.Future

class AccountService @Inject()(
  accountRepository: AccountRepository){

  def debitAccount(account: Account, client: Client, value:BigDecimal) = {
    //hacemos las validaciones semejantes a la anterior
  }

  def operationSimple(account: Account, client: Client, typeOperation: String, value:BigDecimal): Future[BankMovementsDto] ={
    val accountUp =  if(typeOperation.toLowerCase.equalsIgnoreCase("CONSIGNAR")){
      account.copy(balance = Balance.apply(account.balance.saldo + value).getOrElse(account.balance))
    }else{
      account.copy(balance = Balance.apply(account.balance.saldo - value).getOrElse(account.balance))
    }
    accountRepository.saveMovement(accountUp, accountUp, "CONSIGNACION", value)
  }

  def getAccount(idAccount:String) = {
    accountRepository.getAccountById(idAccount)
  }

  def transfer(rootAccount: Account, destinationAccount: Account, value:BigDecimal) = {
  }

}
