package co.com.uco.banking.model.lending

sealed trait LendingState {

}

case object Approved extends LendingState
case object Pending extends LendingState
case object Denied extends LendingState
