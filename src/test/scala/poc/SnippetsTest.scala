package poc


import java.util.Date
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.GivenWhenThen
import poc.resources.Snippets._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class SnippetsTest extends FunSuite with GivenWhenThen {

  test("Generate a Tabletime") {
    val xml = generateTimetable(new Date())
    assert(xml != null)
    assert(!xml.isEmpty)
  }

  test("Generate a list of working time range") {
    given("a list of string representing date and time")
    val list = List("201107180900", "201107180930", "201107181000", "201107181030",
        "201107181100", "201107181230", "201107181300", "201107181400",
        "201107181430", "201107181500", "201107181530")

    when("convert and group the list")
    val dates = string2Date(list)
    val ranges = groupWorkingTimeList(dates)

    then("the list should be contains three ranges")
    assert(ranges.size == 3)

    and("the sum of these ranges should be equals to 4h")
    val time = countTime(ranges)
    assert(time/3600000.0 == 4)
  }

  test("Convert a list of range time to a list of index time.") {
    given("a list of string range representing date and time")
    val ranges = List(("201107180900", "201107181100"),
        ("201107181230", "201107181300"), ("201107181400", "201107181830"))

    when("convert and detail the list")
    val dateRanges = stringTuple2DateTuple(ranges)
    val list = detailWorkingTimeList(dateRanges)

    then("the list should be contains 17 elements")
    assert(list.size == 17)
  }

}
