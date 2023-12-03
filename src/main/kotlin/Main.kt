fun getResourceAsText(path: String): String? =
    object {}.javaClass.getResource(path)?.readText()

fun main(args: Array<String>) {
//    val day1Input = getResourceAsText("day-1")
//    if (day1Input != null) {
//        val lines = day1Input.split("\r?\n|\r".toRegex())
//        println(Day1().solve(lines))
//    }

    val day2Input = getResourceAsText("day-2")
    if (day2Input != null) {
        val lines = day2Input.split("\r?\n|\r".toRegex())
        println(Day2().solve(lines))
        println(Day2().solvePart2(lines))
    }
}