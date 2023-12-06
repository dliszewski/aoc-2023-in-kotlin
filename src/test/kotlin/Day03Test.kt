import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class Day03Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // given
            val input = readInput("Day03_test")

            // when
            val answer = Day03().part1(input)

            // then
            assertThat(answer).isEqualTo(4361)
        }

        @Test
        fun `Actual answer`() {
            // given
            val input = readInput("Day03")

            // when
            val answer = Day03().part1(input)

            // Assert
            assertThat(answer).isEqualTo(530849)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // given
            val input = readInput("Day03_test")

            // when
            val answer = Day03().part2(input)

            // then
            assertThat(answer).isEqualTo(467835)
        }

        @Test
        fun `Actual answer`() {
            // given
            val input = readInput("Day03")

            // when
            val answer = Day03().part2(input)

            // Assert
            assertThat(answer).isEqualTo(71535)
        }
    }
}