package co.com.banking.domain.services

import co.com.banking.infrastructure.builders.AccountBuilder
import co.com.banking.infrastructure.persistence.dao.{AccountDAO, BankMovementsDAO}
import co.com.banking.infrastructure.persistence.repository.AccountRepository
import javax.inject.Inject

import scala.concurrent.ExecutionContext

class ClientService @Inject()(
  accountReposity: AccountRepository){

  def getClient(typeId:String, numId:String) = {

    //consulta al repository y me devuelve la cuenta
  }

}
