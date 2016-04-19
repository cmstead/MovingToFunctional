object DataFactory {

  def buildRecord(dateInSeconds:Int, total: Double, transactionType: String) = {
    Map(("date", dateInSeconds), ("transactionType", transactionType), ("total", total))
  }

  def getDateSeconds (dayDelta: Int) = {
    val secondDelta = dayDelta * 24 * 60 * 60
    val now = System.currentTimeMillis() / 1000

    (now - secondDelta).asInstanceOf[Int]
  }

  def getRandomDayCount () = {
    scala.util.Random.nextInt(30)
  }

  def getOldDate () = {
    getDateSeconds(getRandomDayCount() + 31)
  }

  def getCurrentDate () = {
    getDateSeconds(getRandomDayCount())
  }

  def getFutureDate () = {
    getDateSeconds(getRandomDayCount() - 31)
  }

  def buildOldTestData() = {
    buildRecord(getOldDate(), 48.98, "refund")  ::
    buildRecord(getOldDate(), 7.50, "sale")     ::
    buildRecord(getOldDate(), 99.01, "refund")  ::
    buildRecord(getOldDate(), 11.22, "nosale")  ::
    buildRecord(getOldDate(), 34.25, "sale")    ::
    buildRecord(getOldDate(), 19.19, "refund")  ::
    buildRecord(getOldDate(), 67.41, "sale")    :: Nil
  }

  def buildFutureTestData() = {
    buildRecord(getFutureDate(), 56.98, "sale")  ::
    buildRecord(getFutureDate(), 3.50, "refund") :: Nil
  }

  def buildCurrentTestData() = {
    buildRecord(getCurrentDate(), 9.73, "sale")   ::
    buildRecord(getCurrentDate(), 71.29, "refund")  ::
    buildRecord(getCurrentDate(), 85.07, "refund")  ::
    buildRecord(getCurrentDate(), 12.31, "nosale")  ::
    buildRecord(getCurrentDate(), 10.88, "sale")  ::
    buildRecord(getCurrentDate(), 61.95, "sale")  ::
    buildRecord(getCurrentDate(), 0.98, "refund")   ::
    buildRecord(getCurrentDate(), 95.37, "sale")  :: Nil
  }

  def buildNewTestData() = {
    buildOldTestData()      :::
    buildCurrentTestData()  :::
    buildFutureTestData()
  }
}