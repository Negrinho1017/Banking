package co.com.banking.domain.entities.account

import domain.exceptions.AccountNumberErrors

import scala.util.Try

case class AccountNumber(number:Long) {}

object AccountNumber{
  def apply(number: String): Either[AccountNumberErrors, AccountNumber] = {
    Try(number.toLong).fold[Either[AccountNumberErrors, AccountNumber]](ex => Left(AccountNumberErrors()), v => Right(AccountNumber(v)))
  }
}
