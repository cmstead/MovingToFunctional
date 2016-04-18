import org.scalatest._
import ThirtyDayTotal._

class ThirtyDayTotalSpec extends FlatSpec with Matchers {

  it should "Pass" in {
    val result = new ThirtyDayTotal()

		result.total should be (0.0)
	}

}
