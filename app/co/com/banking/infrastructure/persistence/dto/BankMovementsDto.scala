package co.com.banking.infrastructure.persistence.dto

case class BankMovementsDto(
                           // deberiamos incluir cuenta origen, cuando es consignación la cuenta origen es la misma destino
                               codeMovement: String,
                               movementType: Option[String],
                               rootAccount: Option[String],
                               destinationAccount: Option[String],
                               amount: Option[Double]
                               )
