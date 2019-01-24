// Riku Pepponen
// Thanks to the Big Nerd Ranch!

const val TAVERN_NAME = "Taernyl's Folly"

fun main(args: Array<String>) {
    placeOrder("shandy,Dragon's Breath,5.91")
}

private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiou]")) {
        when (it.value) {
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
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

    val phrase = if (drinkName == "Dragon's Breath") {
        "Madrigal exclaims: ${toDragonSpeak("Ah, delicious $drinkName!")}"
        } else {
        "Madrigal says: Thanks for the $drinkName."
    }
    println(phrase)
}