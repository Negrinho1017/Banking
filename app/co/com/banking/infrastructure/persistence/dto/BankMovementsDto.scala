package co.com.banking.infrastructure.persistence.dto

case class BankMovementsDto(
                               codeMovement: String,
                               movementType: Option[String],
                               rootAccount: Option[String],
                               destinationAccount: Option[String],
                               amount: Option[Double]
                               )
