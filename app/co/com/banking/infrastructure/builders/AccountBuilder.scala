package infrastructure.builders

import co.com.banking.infrastructure.persistence.dto.AccountDto
import domain.account.Account

class AccountBuilder {
  def convertFromDomainToDto(account: Account): AccountDto = {
    AccountDto(account.accountNumber.number.toString,
      Some(account.typeAccount.toString),
      Some(account.state.toString),
      Some(account.balance.saldo.toDouble))
  }
}
