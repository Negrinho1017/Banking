package co.com.banking.domain.entities.account

import domain.exceptions.BalanceErrors


case class Balance(saldo:BigDecimal)

object Balance{
  def apply(saldo: BigDecimal): Either[BalanceErrors, Balance] = saldo match {
    case a if a >= 0 => Right(new Balance(a))
    case _ => Left(BalanceErrors(description = "The Balance is negative"))
  }
}
