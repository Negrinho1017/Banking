package co.com.banking.presentation.request

case class TransferRequest(originAccount:Long, destinationAccount:Long, tipoId: String, numId:String, value: BigDecimal) {}

case object TransferRequest{
  def apply(originId:Long, destinationId:Long, tipoId: String, numId:String, value: BigDecimal):TransferRequest ={
    new TransferRequest(originId, destinationId, tipoId, numId, value)
  }
}