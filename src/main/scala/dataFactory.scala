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
    buildRecord(getOldDate(), 48.98, "sale") :: Nil
  }

  def buildNewTestData() = {
    buildRecord(0, 48.98, "sale") ::
    buildRecord(0, 48.98, "sale") ::
    buildRecord(0, 48.98, "sale") ::
    buildRecord(0, 48.98, "sale") ::
    buildRecord(0, 48.98, "sale") ::
    buildRecord(0, 48.98, "sale") ::
    buildRecord(0, 48.98, "sale") ::
    buildRecord(0, 48.98, "sale") ::
    buildRecord(0, 48.98, "sale") ::
    buildRecord(0, 48.98, "sale") ::
    buildRecord(0, 48.98, "sale") ::
    buildRecord(0, 48.98, "sale") ::
    buildRecord(0, 48.98, "sale") ::
    buildRecord(0, 48.98, "sale") ::
    buildRecord(0, 48.98, "sale") ::
    buildRecord(0, 48.98, "sale") ::
    buildRecord(0, 48.98, "sale") ::
    buildRecord(0, 48.98, "sale") ::
    buildRecord(0, 48.98, "sale") ::
    buildRecord(0, 48.98, "sale") :: Nil
  }
}