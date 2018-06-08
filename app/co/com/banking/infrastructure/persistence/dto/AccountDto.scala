package co.com.banking.infrastructure.persistence.dto

case class AccountDto(
                           accountNumber: String,
                           typeAccount: Option[String],
                           state: Option[String],
                           balance: Option[Double]
                         )
