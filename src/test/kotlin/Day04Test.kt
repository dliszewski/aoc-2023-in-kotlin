import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class Day04Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // given
            val input = readInput("Day04_test")

            // when
            val answer = Day04().part1(input)

            // then
            assertThat(answer).isEqualTo(13)
        }

        @Test
        fun `Actual answer`() {
            // given
            val input = readInput("Day04")

            // when
            val answer = Day04().part1(input)

            // Assert
            assertThat(answer).isEqualTo(24542)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // given
            val input = readInput("Day04_test")

            // when
            val answer = Day04().part2(input)

            // then
            assertThat(answer).isEqualTo(30)
        }

        @Test
        fun `Actual answer`() {
            // given
            val input = readInput("Day04")

            // when
            val answer = Day04().part2(input)

            // Assert
            assertThat(answer).isEqualTo(8736438)
        }
    }
}