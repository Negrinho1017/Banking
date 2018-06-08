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

  def getAccount(idAccount:Long) ={
    //consulta al repository y me devuelve la cuenta
  }

}
