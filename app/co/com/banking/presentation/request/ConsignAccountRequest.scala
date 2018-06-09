package co.com.banking.presentation.request

case class ConsignAccountRequest(idAccount:Long, tipoId: String, numId:String, value: BigDecimal) {}

case object ConsignAccountRequest{
  def apply(idAccount:Long, tipoId: String, numId:String, value: BigDecimal):ConsignAccountRequest ={
   new ConsignAccountRequest(idAccount, tipoId, numId, value)
  }
}
