package co.com.banking.infrastructure.persistence.models

case class BankMovementsEntity (
                               codeMovement: String,
                               movementType: Option[String],
                               rootAccount: Option[String],
                               destinationAccount: Option[String],
                               amount: Option[Double]
                               )
