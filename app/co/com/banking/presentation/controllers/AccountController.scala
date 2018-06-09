package co.com.banking.presentation.controllers

import javax.inject.{Inject, Singleton}
import co.com.banking.domain.entities.account.Account
import co.com.banking.domain.services.ClientService
import co.com.banking.infrastructure.persistence.dto.ClientDto
import co.com.banking.presentation.mappers.AccountMapper
import co.com.banking.presentation.request.OperationAccountRequest
import model.services.AccountService
import play.api.libs.json.Json
import play.api.libs.json.Json.toJson
import play.api.mvc.{AbstractController, AnyContent, ControllerComponents, Request}


@Singleton
class AccountController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  //OJO Inyectar dependencias
  val accountService = AccountService
  val clientService = ClientService

  val accountMapper = AccountMapper

  def consignAccount() = Action { implicit request: Request[AnyContent] =>
    println("request: " + request.body.asJson)
    val json = request.body.asJson.get

    //val consign: ConsignAccountRequest = json.as[ConsignAccountRequest]
    //deberiamos mapear esta información que viene del json
    val consign: OperationAccountRequest = accountMapper.consignForm.bindFromRequest().get
    val account = accountService.getAccount(consign.idAccount)
    val client = clientService.getClient(consign.tipoId, consign.numId)

    //val accountResult = accountService.consignAccount(account, client, consign.value)

    //obtenemos el cliente para devolver el result
    //val clientResult = accountService.consignAccount(account, client, consign.value)

    Ok(Json.toJson("Aqui va el account Result"))
  }

  def debitAccount() = Action { implicit request: Request[AnyContent] =>
    println("request: " + request.body.asJson)
    val json = request.body.asJson.get
    //mapeamos el json a un request

    //utiliza el mismo request de consig
    //obtenemos la cuenta y el cliente como en la funcion anterior

    Ok("todo bien")
  }

  def transfer() = Action { implicit request: Request[AnyContent] =>
    println("request: " + request.body.asJson)
    val json = request.body.asJson.get
    //mapeamos el json a un request

    //obtenemos la cuenta y el cliente como en la funcion anterior

    Ok("todo bien")
  }

}