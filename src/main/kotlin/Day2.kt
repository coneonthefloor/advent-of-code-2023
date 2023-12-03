class ColorScore(val red: Int, val green: Int, val blue: Int) {

}

class Day2 {
    val MAX_RED = 12
    val MAX_GREEN = 13
    val MAX_BLUE = 14

    fun solve(input: List<String>): Int {
        var value = 0
        for (line in input) {
            val scores = getColorScores(line)
            if (scores.red <= MAX_RED &&
                scores.blue <= MAX_BLUE &&
                scores.green <= MAX_GREEN
            ) {
                value += getGameIDFromInput(line)
            }
        }
        return value
    }

    fun solvePart2(input: List<String>): Int {
        var value = 0
        for (line in input) {
            val scores = getColorScores(line)
            value += scores.red * scores.green * scores.blue
        }
        return value
    }

    fun isValidGame(game: String): Boolean {
        val gameMatcher = Regex("Game [(.d?)]")
        val match = gameMatcher.matches(game)
        return gameMatcher.matches(game)
    }

    fun getColorScores(input: String): ColorScore {
        val groupedInput = groupInputByColor(input)
        val red = groupedInput.filter { it.contains("red") }
        val green = groupedInput.filter { it.contains("green") }
        val blue = groupedInput.filter { it.contains("blue") }
        return ColorScore(
            red.maxOf { getIntFromString(it) },
            green.maxOf { getIntFromString(it) },
            blue.maxOf { getIntFromString(it) },
        )
    }

    fun groupInputByColor(input: String): List<String> {
        val splitInput = input.split(":")
        val rounds = splitInput[1].split(";")
        val groupedColors = mutableListOf<String>()
        for (item in rounds) {
            item.split(",").forEach {
                groupedColors.add(it.trim())
            }
        }
        return groupedColors
    }

    fun getGameIDFromInput(input: String): Int {
        val splitInput = input.split(":")
        return getIntFromString(splitInput[0])
    }

    fun getIntFromString(input: String): Int {
        val intList = mutableListOf<Int>()
        val regex = Regex("/?(\\d+)")
        regex.findAll(input).forEach {
            intList.add(it.groupValues[1].toInt())
        }
        return intList.sum()
    }
}