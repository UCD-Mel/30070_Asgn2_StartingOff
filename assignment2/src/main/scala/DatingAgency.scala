
import scala.collection.mutable.ArrayBuffer

class DatingAgency:
  private val singles = ArrayBuffer[Single]()
  private val couples = ArrayBuffer[Couple]()

  def addSingle(single: Single): Unit =
    singles += single

  override def toString: String =
    var str = "Couples:\n"
    for couple <- couples do
      str += couple.toString + "\n"
    str += "Singles:\n"
    for single <- singles do
      str += single.name + "\n"
    str

  def performDating: Unit =
    var i = 0
    while i < singles.length/2 do
      lazy val ignoreSingles = Vector(i, singles.length-i-1)
      lazy val avgDesirability = averageSinglesDesirability(ignoreSingles)
      if Date(singles(i), singles(singles.length-i-1)).wasSuccessful(avgDesirability) then
        matchSingles(i, singles.length-i-1)
      else
        i += 1

  def averageSinglesDesirability(ignoreSingles: Vector[Int] = Vector()): Double =
    var totalDesirability = 0
    for i <- singles.indices do
      if !ignoreSingles.contains(i) then
        totalDesirability += singles(i).desirability
    val ingnoreSinglesFound = ignoreSingles.foldLeft(0)((x, y) => x + (if singles.indices.contains(y) then 1 else 0))
    if (singles.length - ingnoreSinglesFound) == 0 then 0.0
    else totalDesirability.toDouble / (singles.length - ingnoreSinglesFound)
        
  private def matchSingles(i: Int, j: Int) = 
    addCouple(Couple(singles(i), singles(j)))
    singles.remove(j)
    singles.remove(i)
  
  private def addCouple(couple: Couple): Unit =
    couples += couple

    
