package co.com.uco.banking.domain.lending

sealed trait LendingState {

}

case object Approved extends LendingState
case object Pending extends LendingState
case object Denied extends LendingState
