class Day1 {
    fun solve(input: List<String>): Int {
        return input.sumOf { getIntFromLine(it) }
    }

    fun getIntFromLine(input: String): Int {
        val formatted = convertSpelledOutNumbers(input)
        val chars = formatted.toCharArray()
        val digits = "123456789"
        val lastDigit = chars.lastOrNull { it in digits }
        val firstDigit = chars.firstOrNull { it in digits }
        val result = String().plus(firstDigit).plus(lastDigit)
        return if (result == "nullnull") 0 else result.toInt()
    }

    private fun convertSpelledOutNumbers(line: String): String {
        var result = line
        val alpha = mapOf(
            "one" to "1",
            "two" to "2",
            "three" to "3",
            "four" to "4",
            "five" to "5",
            "seven" to "7",
            "six" to "6",
            "eight" to "8",
            "nine" to "9",
        )
        for (entry in alpha) {
            val regex = Regex(entry.key)
            val matches = regex.findAll(result)

            for (match in matches) {
                val index = match.range.first()
                result = result.substring(0, index + 1) + entry.value.toString() + result.substring(index + 1)
            }
        }
        return result
    }
}