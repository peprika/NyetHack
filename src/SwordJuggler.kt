// Riku Pepponen
// Thanks to the Big Nerd Ranch!

fun main(args: Array<String>) {
    var swordsJuggling: Int? = null
    val isJugglingProficient = (1..3).shuffled().last() == 3
    if (isJugglingProficient) {
        swordsJuggling = 2
    }

    proficiencyCheck(swordsJuggling)
    swordsJuggling = swordsJuggling!!.plus(1)

    println("You juggle $swordsJuggling swords!")
}

fun proficiencyCheck(swordsJuggling: Int?) {
    swordsJuggling ?: throw IllegalStateException("Player cannot juggle swords")
}