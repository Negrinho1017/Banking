package co.com.uco.banking.model.account

sealed trait State

case object Active extends State
case object Inactive extends State