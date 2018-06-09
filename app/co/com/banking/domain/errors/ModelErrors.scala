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

case class AccountNotFound(description: String = "Cuenta no encontrada") extends ModelErrors
case class ClientNotFound(description: String = "Cliente no encontrado") extends ModelErrors
case class GenericError(description: String) extends ModelErrors

