package domain.account

sealed trait State

case object Active extends State
case object Inactive extends State