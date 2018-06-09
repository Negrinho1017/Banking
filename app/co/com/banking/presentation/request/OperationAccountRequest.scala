package co.com.banking.presentation.request

case class OperationAccountRequest(idAccount:String, tipoId: String, numId:String, value: BigDecimal) {}

case object OperationAccountRequest{
  def apply(idAccount:String, tipoId: String, numId:String, value: BigDecimal):OperationAccountRequest ={
   new OperationAccountRequest(idAccount, tipoId, numId, value)
  }
}
