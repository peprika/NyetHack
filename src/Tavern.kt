// Riku Pepponen
// Thanks to the Big Nerd Ranch!

import kotlin.math.roundToInt
import kotlin.system.exitProcess

// TAVERN NAME
const val TAVERN_NAME = "Taernyl's Folly"

// PLAYER MONEY: 1 Gold = 100 silver
var playerGold = 10
var playerSilver = 10

// BEER CASK
val caskVolume = 5.00
val pintVolume = 0.125
var numOfPintsLeft = caskVolume / pintVolume
var pintsSold = 0

var purchaseFailed = false

fun main(args: Array<String>) {
    placeOrder("shandy,Dragon's Breath,5.91")
    repeat (12) {placeOrder("beer,pint,2.50")
}}

fun performPurchase(drinkPrice: Double) {
    displayBalance()
    val totalPurse = playerGold + (playerSilver / 100.0)
    println("Total purse: $totalPurse")
    println("Purchasing item for $drinkPrice")

    if (totalPurse < drinkPrice) {
        purchaseFailed = true
        println("You don't have enough money to buy that!")
    } else {
        val remainingBalance = totalPurse - drinkPrice
        println("Remaining balance: ${"%.2f".format(remainingBalance)}")

        val remainingGold = remainingBalance.toInt()
        val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
        playerGold = remainingGold
        playerSilver = remainingSilver
        displayBalance()
    }
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

    if (drinkType == "beer") {
        numOfPintsLeft = numOfPintsLeft - 1
        pintsSold++
        if (pintsSold == 12) {
            println("12 pints sold, there's still ${numOfPintsLeft.roundToInt()} pints left to sell!")
        }
    }

    val message = "Madrigal buys a $drinkName ($drinkType) for $drinkPrice."
    println(message)

    performPurchase(drinkPrice.toDouble())

    val phrase = if (purchaseFailed == false) {
        if (drinkName == "Dragon's Breath") {
            "Madrigal exclaims: ${toDragonSpeak("Ah, delicious $drinkName!")}"
        } else {
            "Madrigal says: Thanks for the $drinkName."
        }
    } else {
        "Madrigal says: Thanks for nothing!"
        exitProcess(0)
    }
    println(phrase)
}