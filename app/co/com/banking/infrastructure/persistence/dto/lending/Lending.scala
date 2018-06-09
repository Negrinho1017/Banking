package co.com.banking.infrastructure.persistence.dto.lending

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
