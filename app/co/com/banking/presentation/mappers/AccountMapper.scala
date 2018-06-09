package co.com.banking.presentation.mappers

import co.com.banking.infrastructure.persistence.dto.AccountDto
import co.com.banking.presentation.request.{OperationAccountRequest, TransferRequest}
import play.api.data.Form
import play.api.data.Forms.{mapping, nonEmptyText, of, optional, text}
import play.api.data.format.Formats._


class AccountMapper {

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
      "accountId" -> nonEmptyText,
      "typeId" -> nonEmptyText,
      "numId" -> nonEmptyText,
      "value" -> of(bigDecimalFormat)
    )(OperationAccountRequest.apply)(OperationAccountRequest.unapply)
  )

  val transferForm = Form(
    mapping(
      "IdOrigin" -> of(longFormat),
      "IdDestination" -> of(longFormat),
      "typeId" -> nonEmptyText,
      "numId" -> nonEmptyText,
      "value" -> of(bigDecimalFormat)
    )(TransferRequest.apply)(TransferRequest.unapply)
  )

}
