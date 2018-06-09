package co.com.banking.presentation.mappers

import co.com.banking.infrastructure.persistence.dto.ClientDto
import play.api.data.Form
import play.api.data.Forms.{mapping, nonEmptyText, of, optional, text}

object ClientMapper {

  val clientForm = Form(
    mapping(
      "identification_number" -> nonEmptyText,
      "name" -> optional(text()),
      "last_name" -> optional(text()),
      "cellphone" -> optional(text()),
      "account" -> optional(text())
    )(ClientDto.apply)(ClientDto.unapply)
  )

}
