
class Single(val name: String, val desirability: Int, soughtDesirability: Int):

  def agreeTo(other: Single, avgDesirability: Double): Boolean =
    other.desirability >= soughtDesirability || avgDesirability < other.desirability

