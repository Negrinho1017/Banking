package domain.client

import java.time.ZonedDateTime
import domain.account.Account


case class Client (
  name: String,
  lastName: String,
  birthDate: ZonedDateTime,
  identificationNumber: IdentificationNumber,
  cellphone: Cellphone,
  account: Account
                  )
