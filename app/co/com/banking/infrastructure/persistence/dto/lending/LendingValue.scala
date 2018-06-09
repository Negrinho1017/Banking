package co.com.banking.infrastructure.persistence.dto.lending

import domain.exceptions.LendingValueErrors

class LendingValue(value: BigDecimal) {

}

object LendingValue{
  def apply(lendingValue: BigDecimal): Either[LendingValueErrors, LendingValue] = lendingValue match {
    case a if a >= 0 => Right(new LendingValue(a))
    case _ => Left(LendingValueErrors(description = "The Lending value is negative"))
  }
}

