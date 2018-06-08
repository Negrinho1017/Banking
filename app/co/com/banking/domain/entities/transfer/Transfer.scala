package co.com.banking.domain.entities.transfer

import java.time.ZonedDateTime

import co.com.banking.domain.entities.account.Account


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

