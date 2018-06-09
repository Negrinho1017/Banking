package co.com.banking.infrastructure.builders

import java.time.ZonedDateTime
import co.com.banking.domain.entities.client._
import co.com.banking.infrastructure.persistence.dto.ClientDto
import domain.exceptions.ModelErrors
class ClientBuilder {
  def convertFromDomainToDto(client: Client): ClientDto = {
    ClientDto(client.identificationNumber.number.toString,
      Some(client.name),
      Some(client.lastName),
      Some(client.cellphone.number.toString),
      Some(client.account.accountNumber.number.toString)
    )
  }

  def convertFromDtoToDomain(clientDto: ClientDto): Either[ModelErrors, Client] = {
    val identificationNumber = IdentificationNumber(clientDto.identificationNumber)
    val cellphone = Cellphone(clientDto.cellphone.get)
    for {
      i <- identificationNumber.right
      c <- cellphone.right
    } yield new Client(clientDto.name.get,clientDto.lastname.get,ZonedDateTime.now(), i, c, null)
  }
}
