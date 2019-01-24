// Riku Pepponen
// Thanks to the Big Nerd Ranch!

import kotlin.math.roundToInt
const val TAVERN_NAME = "Taernyl's Folly"

var playerGold = 10
var playerSilver = 10
// 1 Gold = 100 silver

fun main(args: Array<String>) {
    placeOrder("shandy,Dragon's Breath,5.91")
}

fun performPurchase(drinkPrice: Double) {
    displayBalance()
    val totalPurse = playerGold + (playerSilver / 100.0)
    println("Total purse: $totalPurse")
    println("Purchasing item for $drinkPrice")

    val remainingBalance = totalPurse - drinkPrice
    println("Remaining balance: ${"%.2f".format(remainingBalance)}")

    val remainingGold = remainingBalance.toInt()
    val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
    playerGold = remainingGold
    playerSilver = remainingSilver
    displayBalance()
}

private fun displayBalance()  {
    println("Player's purse balance: Gold $playerGold, Silver: $playerSilver")
}

private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiouAEIOU]")) {
        when (it.value) {
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            "A" -> "4"
            "E" -> "3"
            "I" -> "1"
            "O" -> "0"
            "U" -> "|_|"
            else -> it.value
        }
    }
private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order")

    val (drinkType, drinkName, drinkPrice) = menuData.split(',')
    val message = "Madrigal buys a $drinkName ($drinkType) for $drinkPrice."
    println(message)

    performPurchase(drinkPrice.toDouble())

    val phrase = if (drinkName == "Dragon's Breath") {
        "Madrigal exclaims: ${toDragonSpeak("Ah, delicious $drinkName!")}"
        } else {
        "Madrigal says: Thanks for the $drinkName."
    }
    println(phrase)
}