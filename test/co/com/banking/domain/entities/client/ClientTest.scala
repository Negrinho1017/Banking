package co.com.banking.domain.entities.client
import co.com.banking.domain.entities.account.AccountNumber
import domain.exceptions.{CellphoneException, IdentificationNumberException}
import org.scalatest.{FlatSpec, Matchers}

class ClientTest extends FlatSpec with Matchers {
  "The identification number object" should "bring me an identification number" in {
    val identificationNumber = "1017224720"
    IdentificationNumber(identificationNumber) should be(Right(IdentificationNumber(1017224720)))
  }

  "The identification number object" should "bring me an error" in {
    val identificationNumber = "1017224720d"
    IdentificationNumber(identificationNumber) should be(Left(IdentificationNumberException()))
  }

  "The cellphone number object" should "bring me a number" in {
    val cellphoneNumber = "3003417242"
    Cellphone(cellphoneNumber) should be(Cellphone(cellphoneNumber))
  }

  "The cellphone number object" should "bring me an error" in {
    val cellphoneNumber = "3003417242as"
    Cellphone(cellphoneNumber) should be(Left(CellphoneException()))
  }
}
