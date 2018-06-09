package co.com.banking.domain.entities.account

import domain.exceptions.AccountNumberException

import scala.util.Try

case class AccountNumber(number:Long) {}

object AccountNumber{
  def apply(number: String): Either[AccountNumberException, AccountNumber] = {
    Try(number.toLong).fold[Either[AccountNumberException, AccountNumber]](ex => Left(AccountNumberException()), v => Right(AccountNumber(v)))
  }
}
