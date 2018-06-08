package co.com.banking.domain.entities.lending

import java.time.ZonedDateTime

import co.com.banking.domain.entities.client.Client

class Lending (
                client: Client,
                state: LendingState,
                responseDate: Option[ZonedDateTime],
                value: LendingValue,
                id: Int,
                requestDate: ZonedDateTime
              ) {
}
