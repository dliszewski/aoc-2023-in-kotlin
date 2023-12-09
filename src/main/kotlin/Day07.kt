class Day07 {

    fun part1(input: List<String>): Long {
        val sortedByRank = input.map { it.split(" ") }.map { (hand, bid) -> Hand(hand, bid.toInt()) }
                .sorted()
        return sortedByRank
                .mapIndexed { index, hand -> (index + 1L) * hand.bid }
                .sum()
    }

    fun part2(input: List<String>): Long {
        val sortedByRank = input.map { it.split(" ") }
                .map { (hand, bid) -> Hand(hand, bid.toInt(), true) }
                .sorted()
        return sortedByRank
                .mapIndexed { index, hand -> (index + 1L) * hand.bid }
                .sum()
    }

    data class Hand(val cards: String, val bid: Int, val withSwap: Boolean = false) : Comparable<Hand> {

        private val cardsWithJokerSwap: String by lazy {
            if(withSwap) { swappedCards()
            } else {
                cards
            }
        }

        private fun swappedCards(): String {
            val jCount = cards.count { it == 'J' }
            if (jCount == 5 || jCount == 0) return cards
            val groupByChar = cards.filter { it != 'J' }
                    .groupBy { it }
            val maxSize = groupByChar.maxBy { it.value.size }.value.size
            val bestRankChar = if (groupByChar.filter { it.value.size == maxSize }.count() > 1) {
                groupByChar.keys.minBy { "AKQT98765432J".indexOf(it) }
            } else {
                groupByChar.maxBy { it.value.size }.key
            }
            return cards.replace('J', bestRankChar)
        }

        private val isPair: Boolean
            get() = cardsWithJokerSwap.groupBy { it }.filter { it.value.size == 2 }.count() == 1

        private val isTwoPair: Boolean
            get() = cardsWithJokerSwap.groupBy { it }.filter { it.value.size == 2 }.count() == 2

        private val isHighCard: Boolean
            get() = cardsWithJokerSwap.groupBy { it }.count() == 5

        private val isThree: Boolean
            get() = cardsWithJokerSwap.groupBy { it }.filter { it.value.size == 3 }.count() == 1

        private val isFour: Boolean
            get() = cardsWithJokerSwap.groupBy { it }.filter { it.value.size == 4 }.count() == 1

        private val isFive: Boolean
            get() = cardsWithJokerSwap.groupBy { it }.size == 1

        private val isFullHouse: Boolean
            get() {
                val groupBy = cardsWithJokerSwap.groupBy { it }
                return groupBy.filter { it.value.size == 3 }.count() == 1 && groupBy.filter { it.value.size == 2 }.count() == 1
            }

        private val rank: Int
            get() {
                return when {
                    isFive -> 7
                    isFour -> 6
                    isFullHouse -> 5
                    isThree -> 4
                    isTwoPair -> 3
                    isPair -> 2
                    isHighCard -> 1
                    else -> throw IllegalArgumentException("dupa")
                }
            }

        override fun compareTo(other: Hand): Int {
            val rankStrength = if(withSwap) "AKQT98765432J" else "AKQJT98765432"
            return when {
                this.rank < other.rank -> -1
                this.rank > other.rank -> 1
                else -> {
                    // If the ranks are equal, compare the faces of the cards
                    val thisFaces = cards.map { it }
                    val otherFaces = other.cards.map { it }
                    for (i in thisFaces.indices) {
                        val char = thisFaces[i]
                        val other = otherFaces[i]
                        if (rankStrength.indexOf(char) > rankStrength.indexOf(other)) {
                            return -1
                        } else if (rankStrength.indexOf(char) < rankStrength.indexOf(other)) {
                            return 1
                        }
                    }
                    // If all the faces are equal, the hands are equal
                    return 0
                }
            }
        }

        override fun toString(): String {
            return "Hand(cards='$cards', bid=$bid, cardsWithJokerSwap='$cardsWithJokerSwap', rank=$rank)"
        }
    }

}
