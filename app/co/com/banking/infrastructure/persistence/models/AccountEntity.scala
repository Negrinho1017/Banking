package co.com.banking.infrastructure.persistence.models

case class AccountEntity (
                           accountNumber: String,
                           typeAccount: Option[String],
                           state: Option[String],
                           balance: Option[Double]
                         )
