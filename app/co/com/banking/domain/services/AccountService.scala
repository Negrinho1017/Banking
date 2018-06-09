package model.services

import co.com.banking.domain.entities.account.{Account, Balance}
import co.com.banking.domain.entities.client.Client
import co.com.banking.infrastructure.builders.AccountBuilder
import co.com.banking.infrastructure.persistence.dao.{AccountDAO, BankMovementsDAO}
import co.com.banking.infrastructure.persistence.repository.AccountRepository
import javax.inject.Inject

class AccountService @Inject()(
  accountRepository: AccountRepository){

  def debitAccount(account: Account, client: Client, value:BigDecimal) = {
    //hacemos las validaciones semejantes a la anterior
  }

  def operationSimple(account: Account, client: Client, typeOperation: String, value:BigDecimal):Account ={
    if(typeOperation.toLowerCase.equalsIgnoreCase("CONSIGNAR")){
      account.copy(balance = Balance.apply(account.balance.saldo + value).getOrElse(account.balance))
    }else{
      account.copy(balance = Balance.apply(account.balance.saldo - value).getOrElse(account.balance))
    }
  }

  def getAccount(idAccount:String) = {
    accountRepository.getAccountById(idAccount)
  }

  def transfer(rootAccount: Account, destinationAccount: Account, value:BigDecimal) = {
    //aqui hacemos un debito a un cuenta y un credito a otra cuenta
    //persistimos la información
  }

}
