package model.services

import co.com.banking.domain.entities.account.{Account, Balance}
import co.com.banking.domain.entities.client.Client
import co.com.banking.infrastructure.persistence.repository.AccountRepository

object AccountService {

  //Validate type return
  def consignAccount(account: Account, client: Client, value:BigDecimal):Account = {

    //validar porque se puede devolver un either con el error
    val accountUpdate = account.copy(balance = Balance.apply(account.balance.saldo + value).getOrElse(account.balance))

    //OJO Inyeccion de dependencias
    val accountRepository = AccountRepository
    accountRepository.saveConsigAccount(accountUpdate, client)
  }

  def debitAccount(account: Account, client: Client, value:BigDecimal) = {
    //hacemos las validaciones semejantes a la anterior
  }

  def getAccount(idAccount:Long) ={
    //consulta al accountRepository y me devuelve la cuenta
  }

  def transfer(rootAccount: Account, destinationAccount: Account, value:BigDecimal) = {
    //aqui hacemos un debito a un cuenta y un credito a otra cuenta
    //persistimos la información
  }

}
