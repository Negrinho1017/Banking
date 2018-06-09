package co.com.banking.domain.entities.account

import domain.exceptions.{AccountNumberException, BalanceException}
import org.scalatest.{FlatSpec, Matchers}
class AccountTest extends FlatSpec with Matchers {
  "The Account number object" should "bring me an account number" in {
    val accountNumber = "100896574"
    AccountNumber(accountNumber) should be(Right(AccountNumber(100896574)))
  }

  "The Account number object" should "bring me an error" in {
    val accountNumber = "100896574a"
    AccountNumber(accountNumber) should be(Left(AccountNumberException()))
  }

  "The Balance object" should "bring me a balance" in {
    val balance = 7500000
    Balance(balance) should be(Balance(7500000))
  }

  "The Balance object" should "bring me an error" in {
    val balance = -7500000
    Balance(balance) should be(Left(BalanceException("The Balance is negative")))
  }
}
