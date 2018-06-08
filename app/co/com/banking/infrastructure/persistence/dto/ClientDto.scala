package co.com.banking.infrastructure.persistence.dto

case class ClientDto(identificationNumber: String, name: Option[String], lastname: Option[String], cellphone: Option[String], account: Option[String])

