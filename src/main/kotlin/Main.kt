import java.io.File

fun getResourceAsText(path: String): String? =
    object {}.javaClass.getResource(path)?.readText()

fun main(args: Array<String>) {
    val day1Input = getResourceAsText("day-1")
    if (day1Input != null) {
        val lines = day1Input.split("\r?\n|\r".toRegex())
        println(Day1().solve(lines))
    }
}