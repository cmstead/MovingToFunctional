class ThirtyDayTotalFunctional(transactions: List[Map[String, Any]]) {

  var total = ThirtyDayTotalFunctional.totalCurrentTransactions(transactions)

}

object ThirtyDayTotalFunctional {

  def roundTo (precision: Int)(value: Double) = {
    val mag = math pow (10, precision)
    (math floor value * mag) / mag
  }

  def isNoSale (transaction: Map[String, Any]) = {
    transaction("transactionType") == "nosale"
  }

  def isRefund (transaction: Map[String, Any]) = {
    transaction("transactionType") == "refund"
  }

  def isCurrentTransaction (currentDate: Long) = {
    val lowerBound = currentDate - 30 * 24 * 60 * 60

    (transaction: Map[String, Any]) => {
        transaction("date").asInstanceOf[Int] >= lowerBound &&
        transaction("date").asInstanceOf[Int] <= currentDate
    }
  }

  def getTransactionTotal (transaction: Map[String, Any]) = {
    transaction("total").asInstanceOf[Double]
  }

  def getTransactionValue (transaction: Map[String, Any]) = {
    transaction match {
      case transaction if isNoSale(transaction) => 0.0
      case transaction if isRefund(transaction) => getTransactionTotal(transaction) * -1
      case _ => getTransactionTotal(transaction)
    }
  }

  def totalCurrentTransactions (transactions: List[Map[String, Any]]) = {
    val currentSeconds = System.currentTimeMillis() / 1000
    val total = (transactions
                 filter isCurrentTransaction(currentSeconds)
                 map {getTransactionValue _}
                 fold(0.0)) {_+_}

    roundTo(2)(total)
  }
}