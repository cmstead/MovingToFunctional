import org.scalatest._
import DataFactory._

class ThirtyDayTotalSpec extends FlatSpec with Matchers {


  it should "return 0.0 for an empty list" in {
    val result = new ThirtyDayTotal(List())

    result.total should be (0)
  }

  it should "return 0.0 for a nosale list" in {
    val result = new ThirtyDayTotal(buildNoSaleData())

    result.total should be (0)
  }

  it should "return negative value for a refund list" in {
    val result = new ThirtyDayTotal(buildRefundData())

    result.total should be (-157.34)
  }

  it should "return the correct sum for a current list" in {
    val result = new ThirtyDayTotal(buildCurrentTestData())

    result.total should be (20.58)
  }

  it should "return 0 sum for an old list" in {
    val result = new ThirtyDayTotal(buildOldTestData())

    result.total should be (0)
  }

  it should "return 0 sum for an future list" in {
    val result = new ThirtyDayTotal(buildFutureTestData())

    result.total should be (0)
  }

  it should "return the correct sum for a mixed transaction list" in {
    val result = new ThirtyDayTotal(buildNewTestData())

    result.total should be (20.58)
  }

}
