class Day09 {

    fun part1(input: List<String>): Long {
        val numbers = input.map {
            val d = it.split(" ").map { t -> t.toInt() }
            step(d)
        }
        return numbers.sum()
    }

    fun step(history: List<Int>): Long {
        val windows = history.windowed(2, 1)
        val (first, second) = windows.last()
        return if (windows.all { (first, second) -> second - first == 0 }) {
            first + (second - first) + 0L
        } else {
            val nextHistory = windows.map { (first, second) -> second - first }
            val r = step(nextHistory)
            0L + second + r
        }
    }

    fun part2(input: List<String>): Long {
        val numbers = input.map {
            val d = it.split(" ").map { t -> t.toInt() }
            step2(d)
        }
        return numbers.sum()
    }

    fun step2(history: List<Int>): Long {
        val windows = history.windowed(2, 1)
        val (first, second) = windows.first()
        return if (windows.all { (first, second) -> second - first == 0 }) {
            first - (second - first) + 0L
        } else {
            val nextHistory = windows.map { (first, second) -> second - first }
            val r = step2(nextHistory)
            0L + first - r
        }
    }

}
