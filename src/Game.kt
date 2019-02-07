// Riku Pepponen
// Thanks to the Big Nerd Ranch!


fun main(args: Array<String>) {

    // Initialize player
    val player = Player("Kar")

    // Cast a fireball!
    player.castFireball()

    // Where are we?
    val currentRoom: Room = TownSquare()
    println(currentRoom.description())
    println(currentRoom.load())

    // Player status
    printPlayerStatus(player)

}

private fun printPlayerStatus(player: Player) {
    println("(Aura: ${player.auraColor()}) " + "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
    println("${player.name} ${player.formatHealthStatus()}")
}

object Game {
    init {
        println("Welcome, adventurer!")
    }
}