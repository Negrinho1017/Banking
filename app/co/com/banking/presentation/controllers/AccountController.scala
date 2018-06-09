 package co.com.banking.presentation.controllers

import cats.data.EitherT
import javax.inject.{Inject, Singleton}
import co.com.banking.domain.entities.account.Account
import co.com.banking.domain.entities.client.Client
import co.com.banking.domain.services.ClientService
import co.com.banking.infrastructure.persistence.dto.ClientDto
import co.com.banking.presentation.mappers.AccountMapper
import co.com.banking.presentation.request.OperationAccountRequest
import domain.exceptions.{GenericError, ModelErrors}
import model.services.AccountService
import play.api.libs.json.Json
import play.api.mvc.{AbstractController, AnyContent, ControllerComponents, Request}

import scala.concurrent.Future
import scala.util.{Failure, Success}


@Singleton
class AccountController @Inject()(
  cc: ControllerComponents,
  accountService: AccountService,
  clientService: ClientService,
  accountMapper: AccountMapper
) extends AbstractController(cc) {

  def consignAccount() = Action { implicit request: Request[AnyContent] =>
    println("request: " + request.body.asJson)
    val json = request.body.asJson.get

    val consign: OperationAccountRequest = accountMapper.consignForm.bindFromRequest().get


    val account: Future[Either[ModelErrors, Account]] = accountService.getAccount(consign.idAccount)
    val client = clientService.getClient(consign.tipoId, consign.numId)

    val res: EitherT[Future, ModelErrors, Account] = for{
      acc: Account <- EitherT(accountService.getAccount(consign.idAccount))
      client: Client <- EitherT(clientService.getClient(consign.tipoId, consign.numId))
    }yield {
      accountService.operationSimple(acc, client, "CONSIGNAR", consign.value)
    }

    res.value.onComplete(f => f.match{
      case Success(response) => response.fold(error => BadRequest(Json.toJson(GenericError(error.description))), (r: Account) => Ok(Json.toJson(r.toString)))
      case Failure(ex) => {
        println(s"Ha ocurrido una excepción ===> $ex")
        InternalServerError(Json.toJson("Error inesperado en el sistema"))
      }
    })

    Ok(Json.toJson(""))
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