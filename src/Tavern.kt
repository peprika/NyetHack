// Riku Pepponen
// Thanks to the Big Nerd Ranch!

const val TAVERN_NAME = "Taernyl's Folly"

fun main(args: Array<String>) {
    placeOrder()
}

private fun placeOrder() {
    val indexofApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexofApostrophe)
    println("Madrigal speaks with $tavernMaster about their order")
}