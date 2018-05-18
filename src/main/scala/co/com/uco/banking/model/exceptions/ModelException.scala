package co.com.uco.banking.model.exceptions

trait ModelException {
  val description:String
}

case class BalanceException(description:String) extends ModelException
case class IdentificationNumberException(description:String) extends ModelException
