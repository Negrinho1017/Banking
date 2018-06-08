package domain.lending

import java.time.ZonedDateTime
import domain.client.Client

class Lending (
                client: Client,
                state: LendingState,
                responseDate: Option[ZonedDateTime],
                value: LendingValue,
                id: Int,
                requestDate: ZonedDateTime
              ) {
}
