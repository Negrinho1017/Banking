package co.com.uco.banking.model.lending

import java.time.ZonedDateTime

import co.com.banking.Main.Client
import co.com.banking.model.lending.LendingValue

class Lending (
                client: Client,
                state: LendingState,
                responseDate: Option[ZonedDateTime],
                value: LendingValue,
                id: Int,
                requestDate: ZonedDateTime
              ) {
}
