import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class Day02Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // given
            val input = readInput("Day02_test")

            // when
            val answer = Day02().part1(input)

            // then
            assertThat(answer).isEqualTo(8)
        }

        @Test
        fun `Actual answer`() {
            // given
            val input = readInput("Day02")

            // when
            val answer = Day02().part1(input)

            // Assert
            assertThat(answer).isEqualTo(2720)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // given
            val input = readInput("Day02_test")

            // when
            val answer = Day02().part2(input)

            // then
            assertThat(answer).isEqualTo(2286)
        }

        @Test
        fun `Actual answer`() {
            // given
            val input = readInput("Day02")

            // when
            val answer = Day02().part2(input)

            // Assert
            assertThat(answer).isEqualTo(71535)
        }
    }
}