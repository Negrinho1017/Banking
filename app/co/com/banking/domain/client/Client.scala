package co.com.uco.banking.model.client

import java.time.ZonedDateTime

import co.com.uco.banking.model.account.Account

case class Client (
  name: String,
  lastName: String,
  birthDate: ZonedDateTime,
  identificationNumber: IdentificationNumber,
  cellphone: Cellphone,
  account: Account
                  )
