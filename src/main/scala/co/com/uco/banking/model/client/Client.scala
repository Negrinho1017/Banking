package co.com.uco.banking.model.Client

import java.time.ZonedDateTime

import co.com.uco.banking.model.account.Account

case class Client (
  name: String,
  lastName: String,
  birthDate: ZonedDateTime,
  identificationNumber: IdentificationNumber,
  cellphone: String,
  account: Account
                  )
