package co.com.uco.banking.domain.lending

import java.time.ZonedDateTime

import co.com.banking.domain.entities.lending.LendingValue
import co.com.uco.banking.domain.client.Client

class Lending (
                client: Client,
                state: LendingState,
                responseDate: Option[ZonedDateTime],
                value: LendingValue,
                id: Int,
                requestDate: ZonedDateTime
              ) {
}
