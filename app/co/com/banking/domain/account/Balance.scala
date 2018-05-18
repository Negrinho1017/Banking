package co.com.uco.banking.model.account

import co.com.uco.banking.model.exceptions.{BalanceException, ModelException}

case class Balance(saldo:BigDecimal)

object Balance{
  def apply(saldo: BigDecimal): Either[BalanceException, Balance] = saldo match {
    case a if a >= 0 => Right(new Balance(a))
    case _ => Left(BalanceException(description = "The Balance is negative"))
  }
}
