// Riku Pepponen
// Thanks to the Big Nerd Ranch!


fun main(args: Array<String>) {
    println("What would you like to drink?")
    var beverage = readLine()?.let {
        if (it.isNotBlank()) {
            it.capitalize()
        } else {
            "Buttered Ale"
        }
    }
    // beverage = null

    println(beverage)
}