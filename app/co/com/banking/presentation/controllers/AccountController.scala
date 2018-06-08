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

  def consignAccount() = Action { implicit request: Request[AnyContent] =>
    println("request: " + request.body.asJson)
    val json = request.body.asJson.get

    //val consign: ConsignAccountRequest = json.as[ConsignAccountRequest]
    //deberiamos mapear esta información que viene del json
    val consign: ConsignAccountRequest = new ConsignAccountRequest(0L, "", "", 123454.00)

    //OJO Inyectar dependencias
    val accountService = AccountService
    val clientService = ClientService

    val account = accountService.getAccount(consign.idAccount)
    val client = clientService.getClient(consign.tipoId, consign.numId)



    Ok("todo bien")
  }
}