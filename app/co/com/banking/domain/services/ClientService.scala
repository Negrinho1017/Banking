package co.com.banking.domain.services

import co.com.banking.domain.entities.client.Client
import co.com.banking.infrastructure.builders.AccountBuilder
import co.com.banking.infrastructure.persistence.dao.{AccountDAO, BankMovementsDAO}
import co.com.banking.infrastructure.persistence.repository.{AccountRepository, ClientRepository}
import domain.exceptions.ModelErrors
import javax.inject.Inject

import scala.concurrent.{ExecutionContext, Future}

class ClientService @Inject()(
  clientRepository: ClientRepository){

  def getClient(typeId:String, numId:String): Future[Either[ModelErrors, Client]] = {
    clientRepository.getClientById(numId)
  }

}
