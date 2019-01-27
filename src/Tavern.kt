// Riku Pepponen
// Thanks to the Big Nerd Ranch!

import java.io.File
import kotlin.math.roundToInt
import kotlin.system.exitProcess

// TAVERN INFO
const val TAVERN_NAME = "Taernyl's Folly"
val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
const val welcomeMessage = "     *** Welcome to $TAVERN_NAME *** \n"
val patronList = mutableListOf("Eli", "Mordoc", "Sophie")
val lastName = listOf("Ironfoot","Fernsworth","Baggins")
val uniquePatrons = mutableSetOf<String>()
val menuList = File("data/tavern-menu-items.txt")
    .readText()
    .split("\n")

val patronGold = mutableMapOf<String, Double>()

var purchaseFailed = false

// BEER CASK
const val caskVolume = 5.00
const val pintVolume = 0.125
var numOfPintsLeft = caskVolume / pintVolume
var pintsSold = 0


fun main(args: Array<String>) {

    println(welcomeMessage)
    displayMenu()

    if (patronList.contains("Eli")) {
        println("Tavern master $tavernMaster says: Eli's in the back playing cards.")
    } else {
        println("Tavern master $tavernMaster says: Eli isn't here.")
    }

    if (patronList.containsAll(listOf("Sophie", "Mordoc"))) {
        println("$tavernMaster says: The rest are seated by the stew kettle.")
        } else {
        println("$tavernMaster says: The others departed hours ago.")
    }

    patronList.remove("Eli")
    patronList.add("Alex")
    patronList.add(0, "Alex")
    patronList[0] = "Mr. Alex"

    (0..9).forEach {
        val first = patronList.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$first $last"
        uniquePatrons += name
    }
    uniquePatrons.forEach {
        val goldGenerator = (0..10).random().toDouble()
        patronGold[it] = goldGenerator
    }

    displayPatronBalances()

    var orderCount = 0
    while (orderCount <= 5) {
        try {
            placeOrder(uniquePatrons.shuffled().first(), menuList.shuffled().first())
            orderCount++
        } catch (e: NoSuchElementException) {
            println("Everyone got kicked out!")
            exitProcess(0)
        }
    }

    displayPatronBalances()
}

fun performPurchase(price: Double, patronName: String) {
    val totalPurse = patronGold.getValue(patronName)
    if (totalPurse < price) {
        purchaseFailed = true
        println("Get outta here, $patronName!\n")
        uniquePatrons.remove(patronName)
        patronGold.remove(patronName)
    } else {
        patronGold[patronName] = totalPurse - price
    }
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
private fun placeOrder(patronName: String, menuData: String) {

    println("$patronName speaks with $tavernMaster about their order.")

    val (drinkType, drinkName, drinkPrice) = menuData.split(',')

    println("$patronName tries to buy $drinkName ($drinkType) for $drinkPrice.")

    performPurchase(drinkPrice.toDouble(), patronName)

    if ((drinkType == "beer") and (!purchaseFailed)) {
        numOfPintsLeft--
        pintsSold++
        if (pintsSold == 12) {
            println("12 pints sold, there's still ${numOfPintsLeft.roundToInt()} pints left to sell!")
        }
    }

    if (!purchaseFailed) {
        val phrase = if (drinkName == "Dragon's Breath") {
            "$patronName exclaims: ${toDragonSpeak("Ah, delicious $drinkName!")}\n"
        } else {
            "$patronName says: Thanks for the $drinkName.\n"
        }
        println(phrase)
    }
}

private fun displayPatronBalances() {
    patronGold.forEach { patron, balance ->
        println("$patron, balance: ${"%.2f".format(balance)}")
    }
    print("\n")
}

private fun displayMenu() {
    menuList.forEachIndexed { index, data ->
        val (_, name, price) = data.split(',')
        val numberOfDots = welcomeMessage.length - name.length - price.length
        println("[${index+1}] " + name.capitalize() + ".".repeat(numberOfDots) + price)
    }
    print("\n")
}