import org.scalatest.funsuite.AnyFunSuite

class CoupleSuite extends AnyFunSuite:

  test("toString returns correct string for couple") {
    val single1 = Single("John", 5, 10)
    val single2 = Single("Alex", 5, 10)
    val couple = Couple(single1, single2)
    assert(couple.toString == "(John, Alex)")
  }
