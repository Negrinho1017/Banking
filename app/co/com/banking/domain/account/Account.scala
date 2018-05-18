package co.com.uco.banking.model.account

import java.time.ZonedDateTime

case class Account(
   balance: Balance,
   accountNumber: AccountNumber,
   creationDate:ZonedDateTime,
   state: State,
   inactiveDate: Option[ZonedDateTime],
   typeAccount:TypeAccount) {

}
