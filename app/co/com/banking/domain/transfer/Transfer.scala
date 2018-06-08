package co.com.uco.banking.model.transfer

import java.time.ZonedDateTime

import co.com.banking.model.transfer.TransferValue
import co.com.uco.banking.model.account.Account

case class Transfer(
                     originAccount: Account,
                     destinationAccount: Account,
                     value: TransferValue,
                     date: ZonedDateTime,
                     id: Int
              ) {
}
object Transfer{
  def apply(originAccount: Account,
            destinationAccount: Account,
            value: TransferValue,
            date: ZonedDateTime,
            id: Int): Either[String, Transfer] = {
    if(originAccount.accountNumber == destinationAccount.accountNumber)
      Left("Misma cuenta")
    else
      Right(new Transfer(originAccount, destinationAccount, value, date, id))
  }
}

