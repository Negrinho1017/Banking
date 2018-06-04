package co.com.banking.infrastructure.persistence.models

import play.api.libs.json._

case class Client(identificationNumber: String, name: String, lastname: String)

object Client {
  implicit val implicitClientWrites = new Writes[Client] {
    override def writes(client: Client): JsValue = {
      Json.obj(
        "name" -> client.name,
        "last_name" -> client.lastname
      )
    }
  }
}