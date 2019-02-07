// Riku Pepponen
// Thanks to the Big Nerd Ranch!


fun main(args: Array<String>) {
    Game.play()
}


object Game {
    // Initialize player
    val player = Player("Kar")

    // Where are we?
    val currentRoom: Room = TownSquare()

    // Initialization block
    init {
        println("Welcome, adventurer!")

        // Cast a fireball!
        player.castFireball()
    }

    // Game play
    fun play() {
        while(true) {
            println(currentRoom.description())
            println(currentRoom.load())

            // Player status
            printPlayerStatus(player)

            print("> Enter your command: ")
            println("Last command: ${readLine()}")
        }
    }

    // Print player status
    private fun printPlayerStatus(player: Player) {
        println("(Aura: ${player.auraColor()}) " + "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
        println("${player.name} ${player.formatHealthStatus()}")
    }

    private class GameInput(arg: String?) {
        private val input = arg ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1, { "" })

        private fun commandNotFound() = "I'm not quite sure what you're trying to do..."
    }
}