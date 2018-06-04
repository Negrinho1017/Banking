package co.com.banking.infrastructure.persistence.models
import java.util.Date
import play.api.libs.json._

case class ClientEntity(identificationNumber: String, name: Option[String], lastname: Option[String], cellphone: Option[String], account: Option[String])

