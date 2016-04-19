class ThirtyDayTotal(transactions: List[Map[String, Any]]) {

  var total = ThirtyDayTotal.totalCurrentTransactions(transactions)

}

object ThirtyDayTotal {

  // This is a freebie because the implementation is not
  // important to the greater lesson.
  def roundTo (precision: Int)(value: Double) = {
    val mag = math pow (10, precision)
    (math floor value * mag) / mag
  }

  def getTransactionValue (transaction: Map[String, Any]) = {
    var transactionValue = transaction("total").asInstanceOf[Double]

    if(transaction("transactionType") == "nosale") {
      transactionValue = 0.0
    } else if (transaction("transactionType") == "refund") {
      transactionValue = transactionValue * -1
    }

    transactionValue
  }

  def filterTransactionsByDate (currentSeconds: Long, transactions: List[Map[String, Any]]) = {
    var filteredTransactions: List[Map[String, Any]] = List()
    var lowerBound = currentSeconds - 30 * 24 * 60 * 60

    for(transaction <- transactions) {
      var transactionDate = transaction("date").asInstanceOf[Int]

      if(transactionDate >= lowerBound && transactionDate <= currentSeconds) {
        filteredTransactions = transaction :: filteredTransactions
      }
    }

    filteredTransactions
  }

  def addTransactionTotals (transactions: List[Map[String, Any]]) = {
    var total = 0.0

    for(transaction <- transactions) {
      total += getTransactionValue(transaction)
    }

    total
  }

  def totalCurrentTransactions (transactions: List[Map[String, Any]]) = {
    var currentSeconds = System.currentTimeMillis() / 1000
    var currentTransactions = filterTransactionsByDate(currentSeconds, transactions)
    val total = addTransactionTotals(currentTransactions)

    roundTo(2)(total)
  }
}