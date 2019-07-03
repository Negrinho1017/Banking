package co.com.banking.infrastructure.builders

import java.time.ZonedDateTime

import co.com.banking.infrastructure.persistence.dto.AccountDto
import co.com.banking.domain.entities.account._
import domain.exceptions.ModelErrors

class AccountBuilder {
  def convertFromDomainToDto(account: Account): AccountDto = {
    AccountDto(account.accountNumber.number.toString,
      Some(account.typeAccount.toString),
      Some(account.state.toString),
      Some(account.balance.saldo.toDouble))
  }

  def convertFromDtoToDomain(accountDto: AccountDto): Either[ModelErrors, Account] = {
    val balance = Balance(BigDecimal.double2bigDecimal(accountDto.balance.get))
    val accountNumber = AccountNumber(accountDto.accountNumber)
    for{
      b <- balance
      a <- accountNumber
    } yield new Account(b, a, ZonedDateTime.now(), Active, None, Personal)
  }


}

