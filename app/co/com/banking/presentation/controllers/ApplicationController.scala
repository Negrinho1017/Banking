package co.com.banking.presentation.controllers

import co.com.banking.infrastructure.persistence.dao.{AccountDAO, BankMovementsDAO, ClientDAO}
import co.com.banking.infrastructure.persistence.dto.{AccountDto, BankMovementsDto, ClientDto}
import co.com.banking.presentation.mappers.{AccountMapper, ClientMapper}
import javax.inject.Inject
import play.api.data.{Form, Mapping}
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


  //inyectamos el mapper, inyeccion de dependencias
  val clientMapper = ClientMapper
  val accountMapper = AccountMapper


  def index = Action.async {
    clientDAO.all().map(client => Ok(toJson("Client added correctly" + client)))
  }

  def insertClient = Action.async { implicit request =>
    val client: ClientDto = clientMapper.clientForm.bindFromRequest.get
      clientDAO.insert(client).map(_ => Ok(toJson("Account created correctly")))
    }

  def createNewAccount = Action.async { implicit request =>
    val account: AccountDto = accountMapper.accountForm.bindFromRequest.get
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

  def findMovement = Action.async { implicit request =>
    val movement: BankMovementsDto = movementForm.bindFromRequest.get
    val movementResult = for {
      movementR <- bankMovementsDAO.findByCodeMovement(movement.codeMovement)
    } yield (movementR)
    movementResult.map{

      case movementR =>
        movementR match {
          case Some(c) =>  Ok(toJson(movementForm.fill(c).data))
          case None => NotFound
        }

    }
  }

  def findByMovementType = Action.async { implicit request =>
    val movementRequest: Map[String, String] = movementForm.bindFromRequest.data
    val movementResponse = for {
      movementRe <- bankMovementsDAO.findByMovementType(movementRequest.get("movement_type").get)
    } yield (movementRe)
    movementResponse.map{

      case movementRe =>
        movementRe match {
          case Some(c) => Ok(toJson(movementForm.fill(c).data))
          case None => NotFound
        }
    }
  }

  def findByCodeMovement(codeMovement: String) = Action.async { implicit request =>
    val findMovement = for {
      movement <- bankMovementsDAO.findByCodeMovement(codeMovement)
    } yield (movement)

    findMovement.map{
      case (movement) =>
        movement match {
          case Some(c) => Ok(toJson(movementForm.fill(c).data))
          case None => NotFound
        }
    }

  }



}
