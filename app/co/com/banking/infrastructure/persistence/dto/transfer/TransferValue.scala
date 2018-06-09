package co.com.banking.infrastructure.persistence.dto.transfer

import domain.exceptions.TransferValueErrors


class TransferValue(value: BigDecimal) {

}
object TransferValue{
  def apply(transferValue: BigDecimal): Either[TransferValueErrors, TransferValue] = transferValue match {
    case a if a >= 0 => Right(new TransferValue(a))
    case _ => Left(TransferValueErrors(description = "The Transfer value is negative"))
  }
}
