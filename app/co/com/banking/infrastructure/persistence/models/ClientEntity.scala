package co.com.banking.infrastructure.persistence.models

case class ClientEntity(identificationNumber: String, name: Option[String], lastname: Option[String], cellphone: Option[String], account: Option[String])

