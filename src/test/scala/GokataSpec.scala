import org.scalatest._



class GokataSpec extends FlatSpec with ShouldMatchers with GivenWhenThen with BeforeAndAfter {

  var game: Game = _

  before {
    game = Game(5)
  }

  "The board" should "be empty at the start of the game" in {
    game.isEmpty shouldBe true
  }

  "A move" should "be inside the board" in {
    game.afterMove(Black, -1, -1) shouldBe None
    game.afterMove(Black, 6, 5) shouldBe None
  }

  "A black move inside the board on a new game" should "give a new game state" in {
    game.afterMove(Black, 1, 1) should not be None
    game.afterMove(White, 1, 1) shouldBe None
  }

  "After at least a move, isEmpty" should " be false" in {
    gameAfterOneMove.isEmpty shouldBe false
  }

  "A move" should "be played on an empty point" in {
    gameAfterOneMove.afterMove(White, 1, 1) shouldBe None
    gameAfterOneMove.afterMove(White, 1, 2) should not be None
  }

  "Moves" should "alternate from black to white, etc.." in {
    gameAfterOneMove.afterMove(Black, 1, 2) shouldBe None
  }

  def gameAfterOneMove: Game = {
    val gameAfterOneMove = game
      .afterMove(Black, 1, 1)
      .get
    gameAfterOneMove
  }

}