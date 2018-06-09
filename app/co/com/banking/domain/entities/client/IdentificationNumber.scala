package co.com.banking.domain.entities.client

import domain.exceptions.IdentificationNumberErrors

import scala.util.Try

case class IdentificationNumber(number: Long)

object IdentificationNumber{
  def apply(number: String): Either[IdentificationNumberErrors, IdentificationNumber] = {
    Try(number.toLong).fold[Either[IdentificationNumberErrors,IdentificationNumber]](ex => Left(new IdentificationNumberErrors()), v => Right(new IdentificationNumber(v)))
  }
}
