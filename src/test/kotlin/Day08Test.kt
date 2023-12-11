import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class Day08Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // given
            val input = readInput("Day08_test")

            // when
            val answer = Day08().part1(input)

            // then
            assertThat(answer).isEqualTo(2)
        }

        @Test
        fun `Actual answer`() {
            // given
            val input = readInput("Day08")

            // when
            val answer = Day08().part1(input)

            // Assert
            assertThat(answer).isEqualTo(13019)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // given
            val input = """
            LR

            11A = (11B, XXX)
            11B = (XXX, 11Z)
            11Z = (11B, XXX)
            22A = (22B, XXX)
            22B = (22C, 22C)
            22C = (22Z, 22Z)
            22Z = (22B, 22B)
            XXX = (XXX, XXX) 
            """.trimIndent().lines()

            // when
            val answer = Day08().part2(input)

            // then
            assertThat(answer).isEqualTo(6)
        }

        @Test
        fun `Actual answer`() {
            // given
            val input = readInput("Day08")

            // when
            val answer = Day08().part2(input)

            // Assert
            assertThat(answer).isEqualTo(13524038372771)
        }
    }
}