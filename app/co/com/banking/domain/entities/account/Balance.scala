package co.com.uco.banking.domain.account

import co.com.uco.banking.domain.exceptions.BalanceException


case class Balance(saldo:BigDecimal)

object Balance{
  def apply(saldo: BigDecimal): Either[BalanceException, Balance] = saldo match {
    case a if a >= 0 => Right(new Balance(a))
    case _ => Left(BalanceException(description = "The Balance is negative"))
  }
}
