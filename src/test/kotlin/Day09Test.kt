import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class Day09Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // given
            val input = readInput("Day09_test")

            // when
            val answer = Day09().part1(input)

            // then
            assertThat(answer).isEqualTo(114)
        }

        @Test
        fun `Actual answer`() {
            // given
            val input = readInput("Day09")

            // when
            val answer = Day09().part1(input)

            // Assert
            assertThat(answer).isEqualTo(1992273652)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // given
            val input = readInput("Day09_test")

            // when
            val answer = Day09().part2(input)

            // then
            assertThat(answer).isEqualTo(2)
        }

        @Test
        fun `Actual answer`() {
            // given
            val input = readInput("Day09")

            // when
            val answer = Day09().part2(input)

            // Assert
            assertThat(answer).isEqualTo(1012)
        }
    }
}