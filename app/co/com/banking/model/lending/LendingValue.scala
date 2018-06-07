package co.com.banking.model.lending

import co.com.uco.banking.model.exceptions.LendingValueException

class LendingValue(value: BigDecimal) {

}

object LendingValue{
  def apply(lendingValue: BigDecimal): Either[LendingValueException, LendingValue] = lendingValue match {
    case a if a >= 0 => Right(new LendingValue(a))
    case _ => Left(LendingValueException(description = "The Lending value is negative"))
  }
}

