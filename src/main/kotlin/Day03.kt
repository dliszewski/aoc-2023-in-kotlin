class Day03 {

    fun part1(input: List<String>): Long {
        val numbers = input.mapIndexed { row, it -> mapToCodes(it, row) }
        val (symbols, codes) = numbers.flatten().partition { it.symbol }
        val validCodes = codes.filter { code ->
            symbols.any { symbol ->
                symbol.column in code.expandedColumn && symbol.row in code.expandedRow
            }
        }
        return validCodes.sumOf { it.value.toLong() }
    }

    fun part2(input: List<String>): Long {
        val numbers = input.mapIndexed { row, it -> mapToCodes(it, row) }
        val (symbols, codes) = numbers.flatten().partition { it.symbol }
        return symbols
                .filter { it.value == "*" }
                .map { symbol ->
            codes.filter { code -> symbol.column in code.expandedColumn && symbol.row in code.expandedRow }
                    .map { it.value.toLong() }
        }.filter { it.size == 2 }.sumOf { it.reduce { acc, i -> i * acc } }
    }


    private fun mapToCodes(it: String, row: Int): MutableList<Code> {
        var index = 0
        var startCode: Int
        val codes = mutableListOf<Code>()
        while (index < it.length) {
            if (it.elementAt(index).isDigit()) {
                startCode = index
                while (index < it.length && it.elementAt(index).isDigit()) {
                    index++
                }
                codes.add(Code(it.substring(startCode, index), row, startCode))
            } else if (it.elementAt(index) != '.') {
                codes.add(Code("" + it.elementAt(index), row, index, true))
                index++
            } else {
                index++
            }
        }
        return codes
    }

    data class Code(val value: String, val row: Int, val column: Int, val symbol: Boolean = false) {
        val expandedRow = row - 1..row + 1
        val expandedColumn = column - 1..column + (value.length - 1) + 1
    }

}
