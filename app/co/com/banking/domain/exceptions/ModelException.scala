package co.com.uco.banking.domain.exceptions

trait ModelException {
  val description:String
}

case class BalanceException(description:String) extends ModelException
case class LendingValueException(description:String) extends ModelException
case class TransferValueException(description:String) extends ModelException
case class IdentificationNumberException(description:String) extends ModelException
case class CellphoneException(description: String) extends ModelException
case class AccountNumberException(description: String) extends ModelException
