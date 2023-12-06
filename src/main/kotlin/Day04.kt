class Day04 {

    fun part1(input: List<String>): Long {
        return input.map { line ->
            val (_, win, my) = line.split(":", "|")
            val winning = win.split(" ").filter { it.isNotBlank() }
            val myNumbers = my.split(" ").filter { it.isNotBlank() }
            Card(winning, myNumbers)
        }.map { it.calculatePoints() }
                .sum()
    }

    fun part2(input: List<String>): Long {
        val cards = input.map { line ->
            val (_, win, my) = line.split(":", "|")
            val winning = win.split(" ").filter { it.isNotBlank() }
            val myNumbers = my.split(" ").filter { it.isNotBlank() }
            Card(winning, myNumbers)
        }
        val cardsWithCopies = MutableList(cards.size) { 1 }
        cards.mapIndexed { index, card ->
            (1..card.correctNumbers()).forEach {
                cardsWithCopies[index + it] += cardsWithCopies[index]
            }
        }
        return cardsWithCopies.sum().toLong()
    }

    data class Card(val winningNumbers: List<String>, val numbers: List<String>) {
        fun calculatePoints(): Long {
            val size = correctNumbers()
            if (size == 0) {
                return 0
            }
            var result = 1L
            repeat(size - 1) {
                result *= 2
            }
            return result
        }

        fun correctNumbers(): Int {
            return numbers.count { it in winningNumbers }
        }
    }

}
