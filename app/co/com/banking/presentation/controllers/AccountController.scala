 package co.com.banking.presentation.controllers

import cats.data.{EitherT, OptionT}
import javax.inject.{Inject, Singleton}
import co.com.banking.domain.entities.account.Account
import co.com.banking.domain.entities.client.Client
import co.com.banking.domain.services.ClientService
import co.com.banking.infrastructure.persistence.dto.{BankMovementsDto, ClientDto}
import co.com.banking.presentation.mappers.AccountMapper
import co.com.banking.presentation.request.OperationAccountRequest
import domain.exceptions.{GenericError, InvalidOperation, ModelErrors}
import model.services.AccountService
import play.api.libs.json.Json
import play.api.mvc.{AbstractController, AnyContent, ControllerComponents, Request}

import scala.concurrent.Future
import scala.util.{Failure, Success}

 import cats.implicits._

@Singleton
class AccountController @Inject()(
  cc: ControllerComponents,
  accountService: AccountService,
  clientService: ClientService,
  accountMapper: AccountMapper
) extends AbstractController(cc) {


  def consignAccount() = Action { implicit request: Request[AnyContent] =>
    import cats.implicits._
    println("request: " + request.body.asJson)
    val json = request.body.asJson.get

    val consign: OperationAccountRequest = accountMapper.consignForm.bindFromRequest().get


    val account: Future[Either[ModelErrors, Account]] = accountService.getAccount(consign.idAccount)
    val client = clientService.getClient(consign.tipoId, consign.numId)

    val res: EitherT[Future, ModelErrors, BankMovementsDto] = for{
      acc: Account <- EitherT(accountService.getAccount(consign.idAccount))
      client: Client <- EitherT(clientService.getClient(consign.tipoId, consign.numId))
      service <- OptionT.liftF(accountService.operationSimple(acc, client, "CONSIGNAR", consign.value)).toRight[ModelErrors](InvalidOperation())
    }yield {
      service
    }

    res.value.onComplete {
      case Success(response) => response.fold(error => BadRequest(Json.toJson(GenericError(error.description))), r => Ok(Json.toJson(r.toString)))
      case Failure(ex) => {
        println(s"Ha ocurrido una excepción ===> $ex")
        InternalServerError(Json.toJson("Error inesperado en el sistema"))
      }
    }

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