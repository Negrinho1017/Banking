package domain.exceptions

trait ModelErrors {
  val description:String
}

case class BalanceErrors(description:String) extends ModelErrors
case class LendingValueErrors(description:String) extends ModelErrors
case class TransferValueErrors(description:String) extends ModelErrors
case class IdentificationNumberErrors(description:String = "Identificacion invalida") extends ModelErrors
case class CellphoneErrors(description: String = "Numero de celular invalido") extends ModelErrors
case class AccountNumberErrors(description: String = "Numero invalido") extends ModelErrors

