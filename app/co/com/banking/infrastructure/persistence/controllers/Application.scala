package co.com.banking.infrastructure.persistence.controllers

import co.com.banking.infrastructure.persistence.dao.ClientDAO
import co.com.banking.infrastructure.persistence.models.Client
import javax.inject.Inject
import play.api.data.Form
import play.api.data.Forms.mapping
import play.api.data.Forms.text
import play.api.mvc.{AbstractController, ControllerComponents}
import play.api.libs.json.Json.toJson


import scala.concurrent.ExecutionContext

class Application @Inject() (

  clientDAO: ClientDAO,
  controllerComponents: ControllerComponents
)(implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  def index = Action.async {
    clientDAO.all().map(clients => Ok(toJson("Cliente Agregado Correctamente")))
  }


  val clientForm = Form(
    mapping(
      "identification_number" -> text(),
      "name" -> text(),
      "last_name" -> text()
    )(Client.apply)(Client.unapply)
  )


  def insertClient = Action.async { implicit request =>
      val client: Client = clientForm.bindFromRequest.get
      clientDAO.insert(client).map(_ => Redirect(routes.Application.index))
    }

}
