package domain.exceptions

trait ModelException {
  val description:String
}

case class BalanceException(description:String) extends ModelException
case class LendingValueException(description:String) extends ModelException
case class TransferValueException(description:String) extends ModelException
case class IdentificationNumberException(description:String = "Identificacion invalida") extends ModelException
case class CellphoneException(description: String = "Numero de celular invalido") extends ModelException
case class AccountNumberException(description: String = "Numero invalido") extends ModelException
