// Riku Pepponen
// Thanks to the Big Nerd Ranch!

const val TAVERN_NAME = "Taernyl's Folly"

fun main(args: Array<String>) {
    placeOrder("shandy,Dragon's Breath,5.91!")
}

private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order")

    val data = menuData.split(',')
    val drinkType = data[0]
    val drinkName = data[1]
    val drinkPrice = data[2]
    val message = "Madrigal buys a $drinkName ($drinkType) for $drinkPrice."
    println(message)
}