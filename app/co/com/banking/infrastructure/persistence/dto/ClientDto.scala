package co.com.banking.infrastructure.persistence.dto

case class ClientDto(identificationNumber: String,
                     name: Option[String],
                     lastname: Option[String],
                     cellphone: Option[String],
                     account: Option[String])

case object ClientDto{
  def apply(identificationNumber: String,
            name: Option[String],
            lastname: Option[String],
            cellphone: Option[String],
            account: Option[String]): ClientDto = {
    new ClientDto(identificationNumber, name, lastname, cellphone, account)
  }
}