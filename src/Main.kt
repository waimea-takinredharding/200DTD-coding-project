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

import kotlin.random.Random

fun main() {

    val game = buildGrid()

    //getting player names
    print("Enter player 1 name: ")
    val player1 = readln()
    print("Enter player 2 name: ")
    val player2 = readln()

    var turn = 1
    var removeCoin: Int
    gameRules()

    //the primary loop which runs the game
    while (true) {

        displayGrid(game)

        //creating player turn system
        if (turn == 1) {
            println("$player1's turn")
        } else {
            println("$player2's turn")
        }

        //removing a coin from the grid
        removeCoin = 0
        if (game.elementAt(index = 0) != " "){
            println("Take the leftmost coin [Y(yes)]/[N(no)]")
            if (readln().first().uppercase() == "Y") {
                //ending gameloop if removed coin is the Golden one
                if (game.elementAt(index = 0).toString() == "G") {
                    break
                } else {
                    game[0] = " "
                    displayGrid(game)
                }
                removeCoin = 1
            }
        }

        //moving coin in grid
        if (removeCoin != 1) {

            var movedCoin: Int?
            var moveTo: Int?

            while (true) {
                print("which coin to you want to move (read numbers below each): ")
                movedCoin = readln().toIntOrNull()
                if (movedCoin == null) continue
                movedCoin--

                if (game.elementAt(movedCoin) == " ") {
                println("No coin there you silly")
                    continue
                }

                print("where do you want to move the coin to? (read numbers below grid): ")
                moveTo = readln().toIntOrNull()
                if (moveTo == null) continue
                moveTo--

                //if we reach this point everything is probably working
                break
            }

            game[moveTo!!] = game.elementAt(movedCoin!!)
            game[movedCoin] = " "

            // Taking coin
            if (moveTo == 0) {
                if (game.elementAt(index = 0) != " ") {
                    displayGrid(game)
                    println("take the leftmost coin? [Y(yes)]/[N(no)]")
                    if (readln().first().uppercase() == "Y") {
                        if (game.elementAt(index = 0).toString() == "G") {
                            break
                        } else {
                            game[0] = " "
                        }
                    }
                }
            }
        }
        //changing player turns
        turn = if (turn == 1) 2 else 1
    }

    //check to see who has won; break if anyone has done so
    if (turn == 1) println("$player1 has won")
    if (turn == 2) println("$player2 has won")
}

fun displayGrid(grid: MutableList<String>) {
    print("┌")
    print("───┬".repeat(n=grid.size-1))
    println("───┐")

    for (item in grid) {
        print("│")
        if (item == "G"){
            print(" $item ".yellow().bold())
        } else {
            print(" $item ")
        }
    }
    println("│")

    print("└")
    print("───┴".repeat(n=grid.size-1))
    println("───┘")
}


//showing the counters in the grid
fun buildGrid(): MutableList<String> {
    //placing coins
    val list = mutableListOf<String>()

    //place 20 empty spaces
    repeat(15){
        list.add( " " )
    }

    //place the silver coins
    repeat(4){
        list.add(Random.nextInt(1, list.size), "S")
    }

    //place the gold coin
    list.add(Random.nextInt(5, list.size), "G")

    return list
}

//explantion of rules and how to play
fun gameRules() {
    println("Welcome to 'Old Gold")
    println("These are the rules")
    println("You can only move a coin to the left, and only when it is your turn")
    println("You cannot move a coin to the left if another coin is already in that position")
    println("The goal is to be the player that removes the gold piece")
    println("good luck")
}