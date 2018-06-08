package co.com.banking.presentation.controllers

import co.com.banking.infrastructure.persistence.dao.{AccountDAO, BankMovementsDAO, ClientDAO}
import co.com.banking.infrastructure.persistence.dto.{AccountDto, BankMovementsDto, ClientDto}
import javax.inject.Inject
import play.api.data.Form
import play.api.data.Forms.{mapping, nonEmptyText, of, optional, text}
import play.api.data.format.Formats._
import play.api.libs.json.Json.toJson
import play.api.mvc.{AbstractController, ControllerComponents}

import scala.concurrent.ExecutionContext

class ApplicationController @Inject()(

  clientDAO: ClientDAO,
  accountDAO: AccountDAO,
  bankMovementsDAO: BankMovementsDAO,
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
    )(ClientDto.apply)(ClientDto.unapply)
  )

  def insertClient = Action.async { implicit request =>
      val client: ClientDto = clientForm.bindFromRequest.get
      clientDAO.insert(client).map(_ => Ok(toJson("Account created correctly")))
    }

  val accountForm = Form(
    mapping(
      "account_number" -> nonEmptyText,
      "type_account" -> optional(text()),
      "state" -> optional(text()),
      "balance" -> optional(of(doubleFormat))
    )(AccountDto.apply)(AccountDto.unapply)
  )

  def createNewAccount = Action.async { implicit request =>
    val account: AccountDto = accountForm.bindFromRequest.get
    accountDAO.insertAccount(account).map(_ => Ok(toJson("Account created correctly")))
  }


  val movementForm = Form(
    mapping(
      "code_movement" -> nonEmptyText,
      "movement_type" -> optional(text()),
      "root_account" -> optional(text()),
      "destination_account" -> optional(text()),
      "amount" -> optional(of(doubleFormat))
    )(BankMovementsDto.apply)(BankMovementsDto.unapply)
  )

  def saveNewMovement = Action.async { implicit request =>
    val movement: BankMovementsDto = movementForm.bindFromRequest.get
    bankMovementsDAO.insertNewMovement(movement).map(_ => Ok(toJson("Movement added correctly")))
  }

}
