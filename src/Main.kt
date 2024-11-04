/**
 * ------------------------------------------------------------------------
 * 2-Player based game
 * Level 2 programming project
 *
 * by Torrian Kinred-Harding
 *
 * My project will be based off the two-player game 'Old Gold'
 * The aim is to win by being the player to remove the gold coin
 * from the left-most square
 * ------------------------------------------------------------------------
 */


/**
 * Program entry point
 */
fun main() {

    val grid = mutableListOf<String>()

    setupGame(grid)

    showGame(grid)
    //getting player names

}


fun setupGame(grid: MutableList<String>) {
    repeat(20) {
        grid.add(" ")
    }

    grid[12] ="S"
    grid[13] ="G"
}


fun showGame(grid: MutableList<String>) {
    for(square in grid) {
        print("| $square ")
    }
    println("|")
}