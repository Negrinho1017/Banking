package co.com.banking.infrastructure.persistence.repository

import co.com.banking.infrastructure.builders.{AccountBuilder, ClientBuilder}
import co.com.banking.infrastructure.persistence.dao.{AccountDAO, BankMovementsDAO, ClientDAO}
import javax.inject.Inject

import scala.concurrent.ExecutionContext

class ClientRepository @Inject()(
  clientDAO: ClientDAO,
  bankMovementsDAO: BankMovementsDAO,
  clientBuilder: ClientBuilder)(implicit executionContext: ExecutionContext){

  def getClientById(identificationNumber: String)= {
    for {
      client <- clientDAO.findByIdentificationNumber(identificationNumber)
    } yield {
      client.map(cli => clientBuilder.convertFromDtoToDomain(cli))
    }
  }


}
