import org.scalatest._
import DataFactory._
import ThirtyDayTotal._

class ThirtyDayTotalSpec extends FlatSpec with Matchers {


  it should "return 0.0 for an empty list" in {
    val result = new ThirtyDayTotal(List())

		result.total should be (0.0)
	}

}
