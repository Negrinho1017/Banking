package co.com.banking.domain.entities.client

import domain.exceptions.CellphoneException

import scala.util.Try


case class Cellphone(number: Long) {

}
object Cellphone{
  def apply(number: String): Either[CellphoneException, Cellphone] = {
    Try(number.toLong).fold[Either[CellphoneException,Cellphone]](ex => Left(new CellphoneException(ex.toString)),c => Right(new Cellphone(c)))
  }
}

