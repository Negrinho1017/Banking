package co.com.banking.presentation.mappers

import co.com.banking.infrastructure.persistence.dto.AccountDto
import co.com.banking.presentation.request.ConsignAccountRequest
import play.api.data.Form
import play.api.data.Forms.{mapping, nonEmptyText, of, optional, text}
import play.api.data.format.Formats._


object AccountMapper {

  val accountForm = Form(
    mapping(
      "account_number" -> nonEmptyText,
      "type_account" -> optional(text()),
      "state" -> optional(text()),
      "balance" -> optional(of(doubleFormat))
    )(AccountDto.apply)(AccountDto.unapply)
  )

  val consignForm = Form(
    mapping(
      "accountId" -> of(longFormat),
      "typeId" -> nonEmptyText,
      "numId" -> nonEmptyText,
      "value" -> of(bigDecimalFormat)
    )(ConsignAccountRequest.apply)(ConsignAccountRequest.unapply)
  )

}
