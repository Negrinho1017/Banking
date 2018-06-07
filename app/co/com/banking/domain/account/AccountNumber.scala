package co.com.uco.banking.model.account

import co.com.uco.banking.model.exceptions.AccountNumberException

import scala.util.Try

case class AccountNumber(number:Long) {
}
object AccountNumber{
  def apply(number: String): Either[AccountNumberException, AccountNumber] = {
    Try(number.toLong).fold[Either[AccountNumberException, AccountNumber]](ex => Left(new AccountNumberException(ex.toString)), v => Right(new AccountNumber(v)))
  }
}
