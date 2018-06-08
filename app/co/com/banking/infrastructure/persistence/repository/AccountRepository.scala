package co.com.banking.infrastructure.persistence.repository

import co.com.banking.domain.entities.account.Account
import co.com.banking.domain.entities.client.Client

object AccountRepository {

  def saveConsigAccount(account: Account, client: Client): Account={
    //llamamamos los dao y persistimos la información

    //devuelve la cuenta con los datos actualizados
    account:Account
  }

}