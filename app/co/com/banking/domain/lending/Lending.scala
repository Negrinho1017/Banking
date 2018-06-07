package co.com.uco.banking.model.lending

import co.com.uco.banking.model.client.Client
import java.time.ZonedDateTime

class Lending (
              client: Client,
              state: LendingState,
              responseDate: Option[ZonedDateTime],
              value: Double,
              id: Int,
              requestDate: ZonedDateTime
              ) {
}
object Lending{
  def apply(client: Client,
            state: LendingState,
            responseDate: Option[ZonedDateTime],
            value: Double,
            id: Int,
            requestDate: ZonedDateTime): Either[String, Lending] = {
    if(value < 0) Left("Valor invalido")
    else Right(new Lending(client, state, responseDate, value, id, requestDate))
  }
}
