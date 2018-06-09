package co.com.banking.presentation.request

case class OperationAccountRequest(idAccount:Long, tipoId: String, numId:String, value: BigDecimal) {}

case object OperationAccountRequest{
  def apply(idAccount:Long, tipoId: String, numId:String, value: BigDecimal):OperationAccountRequest ={
   new OperationAccountRequest(idAccount, tipoId, numId, value)
  }
}
