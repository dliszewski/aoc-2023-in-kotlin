class Day01 {

    fun part1(input: List<String>): Int {
        return input.sumOf { calibrationValues(it) }
    }

    private fun calibrationValues(input: String): Int {
        val first = input.first { it.isDigit() }.digitToInt()
        val last = input.last { it.isDigit() }.digitToInt()
        return first * 10 + last
    }

    fun part2(input: List<String>): Int {
        return input.sumOf { calibrationValues2(it) }
    }

    private fun calibrationValues2(input: String): Int {
        val codeMap = mapOf(
                "one" to 1,
                "1" to 1,
                "two" to 2,
                "2" to 2,
                "three" to 3,
                "3" to 3,
                "four" to 4,
                "4" to 4,
                "five" to 5,
                "5" to 5,
                "six" to 6,
                "6" to 6,
                "seven" to 7,
                "7" to 7,
                "eight" to 8,
                "8" to 8,
                "nine" to 9,
                "9" to 9
        )
        val f = input.findAnyOf(codeMap.keys)?.second
        val s = input.findLastAnyOf(codeMap.keys)?.second
        return codeMap[f]!! * 10 + codeMap[s]!!
    }
}
