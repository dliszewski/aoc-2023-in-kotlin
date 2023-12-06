import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class Day06Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // given
            val input = readInput("Day06_test")

            // when
            val answer = Day06().part1(input)

            // then
            assertThat(answer).isEqualTo(288)
        }

        @Test
        fun `Actual answer`() {
            // given
            val input = readInput("Day06")

            // when
            val answer = Day06().part1(input)

            // Assert
            assertThat(answer).isEqualTo(128700)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // given
            val input = readInput("Day06_test")

            // when
            val answer = Day06().part2(input)

            // then
            assertThat(answer).isEqualTo(71503)
        }

        @Test
        fun `Actual answer`() {
            // given
            val input = readInput("Day06")

            // when
            val answer = Day06().part2(input)

            // Assert
            assertThat(answer).isEqualTo(39594072)
        }
    }
}