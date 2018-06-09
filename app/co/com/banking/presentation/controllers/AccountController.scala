package co.com.banking.presentation.controllers

import javax.inject.{Inject, Singleton}
import co.com.banking.domain.entities.account.Account
import co.com.banking.domain.services.ClientService
import co.com.banking.presentation.request.ConsignAccountRequest
import model.services.AccountService
import play.api.libs.json.Json
import play.api.mvc.{AbstractController, AnyContent, ControllerComponents, Request}


@Singleton
class AccountController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  //OJO Inyectar dependencias
  val accountService = AccountService
  val clientService = ClientService

  def consignAccount() = Action { implicit request: Request[AnyContent] =>
    println("request: " + request.body.asJson)
    val json = request.body.asJson.get

    //val consign: ConsignAccountRequest = json.as[ConsignAccountRequest]
    //deberiamos mapear esta información que viene del json
    val consign: ConsignAccountRequest = new ConsignAccountRequest(0L, "", "", 123454.00)



    val account = accountService.getAccount(consign.idAccount)
    val client = clientService.getClient(consign.tipoId, consign.numId)

    //obtenemos el cliente para devolver el result
    //val clientResult = accountService.consignAccount(account, client, consign.value)

    Ok("todo bien")
  }

  def debitAccount() = Action { implicit request: Request[AnyContent] =>
    println("request: " + request.body.asJson)
    val json = request.body.asJson.get
    //mapeamos el json a un request

    //obtenemos la cuenta y el cliente como en la funcion anterior

    Ok("todo bien")
  }
}