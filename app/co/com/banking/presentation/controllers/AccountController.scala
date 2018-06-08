package co.com.banking.presentation.controllers

import javax.inject.{Inject, Singleton}

import co.com.banking.domain.entities.account.Account
import play.api.libs.json.Json
import play.api.mvc.{AbstractController, AnyContent, ControllerComponents, Request}


@Singleton
class AccountController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def consignAccount() = Action { implicit request: Request[AnyContent] =>
    println("request: " + request.body.asJson)
    val json = request.body.asJson.get
    //val account: Account = json.as[Account]


    Ok("todo bien")
  }
}