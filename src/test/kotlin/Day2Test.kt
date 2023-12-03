import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day2Test {
    private val testSubject: Day2 = Day2()

    @Test
    fun testSolution() {
        val lines = listOf(
            "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
            "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
            "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
            "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
            "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green",
        )

        assertEquals(8, testSubject.solve(lines))
    }

    @Test
    fun testSolutionPart2() {
        val lines = listOf(
            "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
            "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
            "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
            "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
            "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green",
        )

        assertEquals(2286, testSubject.solvePart2(lines))
    }

    @Test
    fun testIsValidGame() {
        val testInputs = mapOf(
            "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green" to false,
            "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue" to false,
            "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red" to false,
            "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red" to false,
            "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green" to false,
        )

        testInputs.forEach { entry ->
            assertEquals(testSubject.isValidGame(entry.key), entry.value)
        }
    }

    @Test
    fun testGetIntFromString() {
        val testInputs = mapOf(
            "Game 1:" to 1,
            "3 green" to 3,
            "20 red;" to 20
        )

        testInputs.forEach { entry ->
            assertEquals(testSubject.getIntFromString(entry.key), entry.value)
        }
    }

    @Test
    fun testGetGameIDFromInput() {
        val testInputs = mapOf(
            "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green" to 1,
            "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue" to 2,
            "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red" to 3,
            "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red" to 4,
            "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green" to 5,
        )

        testInputs.forEach { entry ->
            assertEquals(testSubject.getGameIDFromInput(entry.key), entry.value)
        }
    }

    @Test
    fun testGroupInputByColor() {
        assertEquals(
            listOf("3 blue", "4 red", "1 red", "2 green", "6 blue", "2 green"),
            testSubject.groupInputByColor(
                "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"
            )
        )
    }

    @Test
    fun testGetColorScores() {
        val predicted = ColorScore(4, 2, 21)
        val actual = testSubject.getColorScores(
            "Game 1: 3 blue, 4 red; 1 red, 2 green, 21 blue; 2 green"
        )
        assertEquals(predicted.red, actual.red)
        assertEquals(predicted.green, actual.green)
        assertEquals(predicted.blue, actual.blue)
    }
}