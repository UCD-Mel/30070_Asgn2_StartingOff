
@main def hello: Unit =
  val datingAgency = DatingAgency()
  val desirabilityRange = Range(1, 11)
  import scala.io.Source
  val filename = "singles.txt"
  for (line <- Source.fromFile(filename).getLines)
    val data = line.split("\\W+") 
    val name = data(0)
    val desirability = data(1).toInt
    require(desirabilityRange.contains(desirability))
    val soughtDesirability = data(2).toInt
    require(desirabilityRange.contains(soughtDesirability))
    datingAgency.addSingle(Single(name, desirability, soughtDesirability))
  datingAgency.performDating
  println(datingAgency.toString)
  