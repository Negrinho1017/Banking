package co.com.uco.banking.model.lending

import java.time.ZonedDateTime

import co.com.banking.infrastructure.persistence.Main.Client

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
