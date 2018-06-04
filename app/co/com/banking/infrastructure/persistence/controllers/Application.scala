package co.com.banking.infrastructure.persistence.controllers

import co.com.banking.infrastructure.persistence.dao.{AccountDAO, ClientDAO}
import co.com.banking.infrastructure.persistence.models.{AccountEntity, ClientEntity}
import javax.inject.Inject
import play.api.data.Form
import play.api.data.Forms.{date, longNumber, mapping, nonEmptyText, optional, text, of}
import play.api.mvc.{AbstractController, ControllerComponents}
import play.api.libs.json.Json.toJson
import play.api.data.format.Formats._

import scala.concurrent.ExecutionContext

class Application @Inject() (

  clientDAO: ClientDAO,
  accountDAO: AccountDAO,
  controllerComponents: ControllerComponents
)(implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  def index = Action.async {
    clientDAO.all().map(clients => Ok(toJson("Client added correctly")))
  }


  val clientForm = Form(
    mapping(
      "identification_number" -> nonEmptyText,
      "name" -> optional(text()),
      "last_name" -> optional(text()),
      "cellphone" -> optional(text()),
      "account" -> optional(text())
    )(ClientEntity.apply)(ClientEntity.unapply)
  )

  def insertClient = Action.async { implicit request =>
      val client: ClientEntity = clientForm.bindFromRequest.get
      clientDAO.insert(client).map(_ => Redirect(routes.Application.index))
    }

  val accountForm = Form(
    mapping(
      "account_number" -> nonEmptyText,
      "type_account" -> optional(text()),
      "state" -> optional(text()),
      "balance" -> optional(of(doubleFormat))
    )(AccountEntity.apply)(AccountEntity.unapply)
  )

  def createNewAccount = Action.async { implicit request =>
    val account: AccountEntity = accountForm.bindFromRequest.get
    accountDAO.insertAccount(account).map(_ => Ok(toJson("Account created correctly")))
  }

}
