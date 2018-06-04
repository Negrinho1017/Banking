package co.com.banking.infrastructure.persistence.models

import play.api.libs.json._

case class Client(identificationNumber: String, name: String, lastname: String)

