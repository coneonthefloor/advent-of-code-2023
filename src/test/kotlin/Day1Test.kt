import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day1Test {
    private val testSubject: Day1 = Day1()

    @Test
    fun testSolutionWorksForSingleLine() {
        val inputs = mapOf(
            "two1nine" to 29,
            "eightwothree" to 83,
            "abcone2threexyz" to 13,
            "xtwone3four" to 24,
            "4nineeightseven2" to 42,
            "zoneight234" to 14,
            "7pqrstsixteen" to 76,
            "1abc2" to 12,
            "pqr3stu8vwx" to 38,
            "a1b2c3d4e5f" to 15,
            "treb7uchet" to 77,
            "zqtwonethreekcz3seven2" to 22,
            "nine" to 99,
            "one983sevensix7" to 17,
            "twone" to 21,
            "oneight" to 18
        )

        inputs.forEach { entry ->
            assertEquals(entry.value, testSubject.getIntFromLine(entry.key))
        }
    }

    @Test
    fun testSolutionWorksForMultiLine() {
        val inputs = listOf(
            "two1nine",
            "eightwothree",
            "abcone2threexyz",
            "xtwone3four",
            "4nineeightseven2",
            "zoneight234",
            "7pqrstsixteen",
        )

        assertEquals(281, testSubject.solve(inputs))
    }
}
