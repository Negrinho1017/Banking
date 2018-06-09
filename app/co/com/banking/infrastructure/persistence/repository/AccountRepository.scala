package co.com.banking.infrastructure.persistence.repository

import co.com.banking.domain.entities.account.Account
import co.com.banking.domain.entities.client.Client

object AccountRepository {

  def saveConsigAccount(account: Account, client: Client): Account={
    //llamamamos los dao y persistimos la información

    //devuelve la cuenta con los datos actualizados
    account:Account
  }

  def getAccountById(countId:Long) = {
    //obtenemos el dto de la consulta
    //invocamos el builder y le mandamos el dto y devolvemos la cuenta
  }

}
