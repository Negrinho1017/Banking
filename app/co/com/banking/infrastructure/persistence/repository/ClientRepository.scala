package co.com.banking.infrastructure.persistence.repository

import cats.data.{EitherT, OptionT}
import co.com.banking.infrastructure.builders.{AccountBuilder, ClientBuilder}
import co.com.banking.infrastructure.persistence.dao.{AccountDAO, BankMovementsDAO, ClientDAO}
import domain.exceptions.ClientNotFound
import javax.inject.Inject
import cats.implicits._

import scala.concurrent.{ExecutionContext, Future}

class ClientRepository @Inject()(
  clientDAO: ClientDAO,
  bankMovementsDAO: BankMovementsDAO,
  clientBuilder: ClientBuilder)(implicit executionContext: ExecutionContext){

  def getClientById(identificationNumber: String)= {
    (for {
      client <- OptionT(clientDAO.findByIdentificationNumber(identificationNumber)).toRight(ClientNotFound())
      cli    <- EitherT.fromEither[Future](clientBuilder.convertFromDtoToDomain(client))
    } yield {
      cli
    }).value
  }


}
