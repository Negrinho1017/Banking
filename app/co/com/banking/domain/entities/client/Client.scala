package co.com.banking.domain.entities.client

import java.time.ZonedDateTime

import co.com.banking.domain.entities.account.Account


case class Client (
  name: String,
  lastName: String,
  birthDate: ZonedDateTime,
  identificationNumber: IdentificationNumber,
  cellphone: Cellphone,
  account: Account)
