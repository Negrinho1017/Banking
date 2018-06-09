package co.com.banking.domain.entities.client

import domain.exceptions.CellphoneErrors

import scala.util.Try

case class Cellphone(number: Long) {}

object Cellphone{
  def apply(number: String): Either[CellphoneErrors, Cellphone] = {
    Try(number.toLong).fold[Either[CellphoneErrors,Cellphone]](ex => Left(new CellphoneErrors()), c => Right(new Cellphone(c)))
  }
}

