import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class Day07Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // given
            val input = readInput("Day07_test")

            // when
            val answer = Day07().part1(input)

            // then
            assertThat(answer).isEqualTo(6440)
        }

        @Test
        fun `Actual answer`() {
            // given
            val input = readInput("Day07")

            // when
            val answer = Day07().part1(input)

            // Assert
            assertThat(answer).isEqualTo(250254244)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // given
            val input = readInput("Day07_test")

            // when
            val answer = Day07().part2(input)

            // then
            assertThat(answer).isEqualTo(5905)
        }

        @Test
        fun `Actual answer`() {
            // given
            val input = readInput("Day07")

            // when
            val answer = Day07().part2(input)

            // Assert
            assertThat(answer).isEqualTo(250087440)
        }
    }
}