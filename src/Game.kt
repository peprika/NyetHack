// Riku Pepponen
// Thanks to the Big Nerd Ranch!


fun main(args: Array<String>) {

    val player = Player()

    // Cast a fireball!
    player.castFireball()

    // Aura
    val auraColor = player.auraColor(player.isBlessed, player.healthPoints, player.isImmortal)

    // Health status
    val healthStatus = player.formatHealthStatus(player.healthPoints, player.isBlessed)

    // Player status
    printPlayerStatus(auraColor, player.isBlessed, player.name, healthStatus)

}

private fun printPlayerStatus(auraColor: String, isBlessed: Boolean, name: String, healthStatus: String) {
    println("(Aura: $auraColor) " + "(Blessed: ${if (isBlessed) "YES" else "NO"})")
    println("$name $healthStatus")
}