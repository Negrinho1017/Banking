package co.com.uco.banking.model.transfer

import java.time.ZonedDateTime

import co.com.uco.banking.model.account.Account

case class Transfer(
              originAccount: Account,
              destinationAccount: Account,
              value: Double,
              date: ZonedDateTime,
              id: Int
              ) {
}
object Transfer{
  def apply(originAccount: Account,
            destinationAccount: Account,
            value: Double,
            date: ZonedDateTime,
            id: Int): Either[String, Transfer] = for{
    _ <- if(value < 0) Left("Valor invalido") else Right(value)
    _ <- if(originAccount.accountNumber == destinationAccount.accountNumber)
      Left("Misma cuenta") else Right(destinationAccount)
  } yield new Transfer(originAccount, destinationAccount, value, date, id)
}

