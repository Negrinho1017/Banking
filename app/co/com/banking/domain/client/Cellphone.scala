package co.com.uco.banking.model.client

import co.com.uco.banking.model.exceptions.CellphoneException

import scala.util.Try

case class Cellphone(number: Long) {

}
object Cellphone{
  def apply(number: String): Either[CellphoneException, Cellphone] = {
    Try(number.toLong).fold[Either[CellphoneException,Cellphone]](ex => Left(new CellphoneException(ex.toString)),c => Right(new Cellphone(c)))
  }
}

