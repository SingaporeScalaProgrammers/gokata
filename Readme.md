# Go Kata

The aim of this kata is to write a program that can determine whether a move in Go is a legal move.  

## The Game Of Go

Go (simplified Chinese: 围棋; traditional Chinese: 圍棋; pinyin: wéiqí, Japanese: 囲碁 igo,  Korean: 바둑 baduk) is a board game involving two players that originated in ancient China more than 2,500 years ago. It was considered one of the four essential arts of a cultured Chinese scholar in antiquity. Its earliest written reference dates back to the Confucian Analects.

There is significant strategy involved in the game, and the number of possible games is vast (10^761 compared, for example, to the 10^120 possible in chess), despite its relatively simple rules.

Go is a very difficult game for computers to play well and professional players still beat the strongest AIs.


### The Board

The board is a grid of horizontal and vertical lines. The lines of the board have intersections wherever they cross or touch each other. Each intersection is called a point. That includes the four corners, and the edges of the board.

![A go Board](https://raw.githubusercontent.com/russellwstanley/gokatatest/master/images/empty_board.png)

The example board has 25 points. The red circle shows one particular point. The red square in the corner shows another point.

Two points connected by a line segment are said to be adjacent or next to one another. The triangles are adjacent. The crosses are not adjacent.

![A go Board](https://raw.githubusercontent.com/russellwstanley/gokatatest/master/images/adjecent_demo.png)

### The Stones

There are 2 players, black and white. The players place pieces (called "stones" on the board)

Players place stones on the points of the board. Here is a board with some stones placed on it.

![A go Board](https://raw.githubusercontent.com/russellwstanley/gokatatest/master/images/board_with_stones.png)


### Capture

If a player surrounds the opponent's stone or stones completely, he captures those stones and removes them from the board.

Every stone on the board must be next to an empty point. (An empty point next to a stone is called a liberty.)

If a stone is not next to an empty point, but it's next to some other stones of the same color which are next to an empty point, that's fine too. (Strings of adjacent stones "share liberties".)

If there are no empty points next to a stone or a string of stones (the stone has no liberties), the stones are immediately taken off the board.

#### Example 1

The white stone is almost surrounded. It is next to only one empty point, shown by the square. (Remember, only points connected by a line segment are next to one another. So the circles do not count as liberties, for example.)

![A go Board](https://raw.githubusercontent.com/russellwstanley/gokatatest/master/images/capture1.png)

Black's move [1] surrounds the white stone completely.

![A go Board](https://raw.githubusercontent.com/russellwstanley/gokatatest/master/images/capture2.png)

The white stone is captured and removed from the board

![A go Board](https://raw.githubusercontent.com/russellwstanley/gokatatest/master/images/capture3.png)

#### Example 2


The three white stones are connected along the lines of the board, and stand or fall together.

![A go Board](https://raw.githubusercontent.com/russellwstanley/gokatatest/master/images/capture4.png)

Black's move [1] occupies their last liberty

![A go Board](https://raw.githubusercontent.com/russellwstanley/gokatatest/master/images/capture5.png)

The 3 white stones are captured and removed from the board

![A go Board](https://raw.githubusercontent.com/russellwstanley/gokatatest/master/images/capture6.png)


### The Rules of Go

1. The board is empty at the onset of the game.
2. Black places the first stone, after which White and Black alternate.
3. Stones cannot be placed on occupied points.
4. Stones cannot be placed where they would be immediately captured
5. If placing a stone causes an opponent's stone to be captured, the opponents stones are removed from the board before the liberties of your stone(s) are calculated
6. You cannot place a stone to put the game back in the same position as it was on your last turn (this prevents infinite loops in play)

### The Kata

Write a program that, given a board state and a move will determine whether the move is a legal Go move, according to the rules 1-6.

