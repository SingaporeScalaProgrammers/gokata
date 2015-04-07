import sun.jvm.hotspot.debugger.cdbg.PointerType

object Application {

  def main(args : Array[String]): Unit ={
    println("Hello Scalaporeans!")
  }

}

sealed trait Point
sealed trait Color extends Point

case object Empty extends Point

case object White extends Color
case object Black extends Color

case class Game(val board: Array[Array[Point]], nextColor: Color) {
  def isEmpty: Boolean = board.forall(isEmptyRow)

  private def isEmptyRow(row: Array[Point]) = row.forall(_ == Empty)

  def afterMove(nextColor: Color, row: Int, col: Int): Option[Game] = nextColor match {
    case White if isEmpty => None
    case _ => {
      if (isInBounds(row, col) &&
        isBlankPoint(row, col) &&
        isCorrectMove(nextColor)) {

        val updatedBoard = board.updated(row, board(row).updated(col, nextColor))
        Some(Game(updatedBoard, otherColor(nextColor)))
      }
      else None
    }
  }

  private def otherColor(color: Color): Color = color match {
    case Black => White
    case White => Black
  }

  private def isCorrectMove(proposedColor: Point) =
    proposedColor == nextColor

  private def isBlankPoint(row: Int, col: Int): Boolean =
    board(row)(col) == Empty

  private def isInBounds(row: Int, col: Int): Boolean =
    row >= 0 && row < size && col >= 0 && col < size

  private def size =
    board.length
}

object Game {
  def apply(size: Int): Game = Game(Array.fill[Point](size,size) { Empty }, Black)
}

