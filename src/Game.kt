// Riku Pepponen
// Thanks to the Big Nerd Ranch!


fun main(args: Array<String>) {

    // Initialize player
    val player = Player()

    // Cast a fireball!
    player.castFireball()

    // Player status
    printPlayerStatus(player)

}

private fun printPlayerStatus(player: Player) {
    println("(Aura: ${player.auraColor()}) " + "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
    println("${player.name} ${player.formatHealthStatus()}")
}