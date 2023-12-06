class Day06 {

    fun part1(input: List<String>): Long {
        val times = mapTimes(input)
        val distance = mapDistances(input)
        val races = times.zip(distance) { a, b -> winStrategies(a.toInt(), b.toInt()) }
        return races.reduce { acc, i -> acc * i }
    }

    fun part2(input: List<String>): Long {
        val time = mapTimes(input).joinToString(separator = "").toInt()
        val recordDistance = mapDistances(input).joinToString(separator = "").toLong()

        var possibleWins = 0L
        for (chargeTime: Int in 0..time) {
            val travelDistance = (time - chargeTime) * chargeTime.toLong()
            if (travelDistance > recordDistance) {
                possibleWins++
            }
        }
        return possibleWins
    }

    private fun winStrategies(time: Int, distance: Int): Long {
        var possibleWins = 0L
        for (chargeTime: Int in 0..time) {
            if ((time - chargeTime) * chargeTime.toLong() > distance) {
                possibleWins++
            }
        }
        return possibleWins
    }

    private fun mapDistances(input: List<String>) = input.last().replace("Distance:", "")
            .split("  ")
            .filter { it.isNotBlank() }
            .map { it.replace(" ", "") }

    private fun mapTimes(input: List<String>) = input.first().replace("Time:", "")
            .split("  ")
            .filter { it.isNotBlank() }
            .map { it.replace(" ", "") }

}
