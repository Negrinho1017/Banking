package co.com.banking.domain.entities.transfer

import domain.exceptions.TransferValueException


class TransferValue(value: BigDecimal) {

}
object TransferValue{
  def apply(transferValue: BigDecimal): Either[TransferValueException, TransferValue] = transferValue match {
    case a if a >= 0 => Right(new TransferValue(a))
    case _ => Left(TransferValueException(description = "The Transfer value is negative"))
  }
}
