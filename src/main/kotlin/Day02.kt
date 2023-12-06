class Day02 {

    fun part1(input: List<String>): Int {
        val maxRed = 12
        val maxBlue = 14
        val maxGreen = 13
        val games = input.map { decodeGameConfig(it) }
        val filter = games
                .filter { it.isValidGame(maxRed, maxGreen, maxBlue) }
        return filter.sumOf { it.id }
    }


    fun part2(input: List<String>): Int {
        val games = input.map { decodeGameConfig(it) }
        val map = games.map { it.minSetOfCubes() }
        return map.sumOf { it.power() }
    }

    private fun decodeGameConfig(input: String): Game {
        val data = input.replace("Game ".toRegex(), "")
        val gameId = data.takeWhile { it.isDigit() }.toInt()
        val cubeSets = input.replace("Game \\d+:".toRegex(), "").split(";").map { mapToCubeSet(it) }
        return Game(gameId, cubeSets)
    }

    private fun mapToCubeSet(set: String): CubeSet {
        var red = 0
        var blue = 0
        var green = 0

        set.split(",")
                .map { it.trim() }
                .map { it.split(" ") }
                .forEach { (number, color) ->
                    when (color) {
                        "red" -> red += number.toInt()
                        "blue" -> blue += number.toInt()
                        "green" -> green += number.toInt()
                    }
                }

        return CubeSet(red, green, blue)
    }

    data class CubeSet(val red: Int, val green: Int, val blue: Int) {
        fun power(): Int {
            return red * blue * green
        }
    }
    data class Game(val id: Int, val cubeSets: List<CubeSet>) {
        fun isValidGame(maxRed: Int, maxGreen: Int, maxBlue: Int): Boolean {
            return cubeSets.all { it.red <= maxRed } &&
                    cubeSets.all { it.blue <= maxBlue } &&
                    cubeSets.all { it.green <= maxGreen }
        }

        fun minSetOfCubes(): CubeSet {
            val a = cubeSets.maxOf { it.red }
            val b = cubeSets.maxOf { it.green }
            val c = cubeSets.maxOf { it.blue }
            return CubeSet(a, b, c)
        }

        override fun toString(): String {
            val r = cubeSets.sumOf { it.red }
            val b = cubeSets.sumOf { it.blue }
            val g = cubeSets.sumOf { it.green }
            return "Game(id=$id, cubeSets=red:$r blue:$b green:$g)"
        }

    }

}
