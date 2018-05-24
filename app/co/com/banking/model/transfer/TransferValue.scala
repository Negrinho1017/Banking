package co.com.banking.model.transfer

import co.com.uco.banking.model.exceptions.TransferValueException

class TransferValue(value: BigDecimal) {

}
object LendingValue{
  def apply(transferValue: BigDecimal): Either[TransferValueException, TransferValue] = transferValue match {
    case a if a >= 0 => Right(new TransferValue(a))
    case _ => Left(TransferValueException(description = "The Transfer value is negative"))
  }
}
