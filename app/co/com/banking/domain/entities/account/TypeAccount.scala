package co.com.banking.domain.entities.account

sealed trait TypeAccount

case object Bank extends TypeAccount
case object Personal extends TypeAccount
