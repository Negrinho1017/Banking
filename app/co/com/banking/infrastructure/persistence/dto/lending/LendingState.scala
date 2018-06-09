package co.com.banking.infrastructure.persistence.dto.lending

sealed trait LendingState {

}

case object Approved extends LendingState
case object Pending extends LendingState
case object Denied extends LendingState
