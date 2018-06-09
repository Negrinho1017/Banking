package co.com.banking.domain.entities.client

import domain.exceptions.IdentificationNumberException

import scala.util.Try

case class IdentificationNumber(number: Long)

object IdentificationNumber{
  def apply(number: String): Either[IdentificationNumberException, IdentificationNumber] = {
    Try(number.toLong).fold[Either[IdentificationNumberException,IdentificationNumber]](ex => Left(new IdentificationNumberException()),v => Right(new IdentificationNumber(v)))
  }
}
