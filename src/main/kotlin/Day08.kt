class Day08 {

    fun part1(input: List<String>): Long {
        val directions = input.first()
        val firstNode = input.drop(2).take(1).map { it.split(" = (") }.map { (node, routes) -> parseNode(node, routes) }.first()
        val network = input.drop(2).map { it.split(" = (") }.associate { (node, routes) -> node to parseNode(node, routes) }
        return calculateSteps(firstNode, directions, network, "ZZZ")
    }

    fun part2(input: List<String>): Long {
        val directions = input.first()
        val network = input.drop(2).map { it.split(" = (") }.associate { (node, routes) -> node to parseNode(node, routes) }
        val staringNodes = network.entries.filter { it.key.endsWith("A") }.map { it.value }
        val stepsForEach = staringNodes.map { calculateSteps(it, directions, network, "Z") }
        return findLCMO(stepsForEach)
    }

    private fun calculateSteps(firstNode: Node, directions: String, network: Map<String, Node>, suffix: String): Long {
        var steps = 0L
        var directionIndex = 0
        var currentNode: Node = firstNode
        while (!currentNode.isEndNode(suffix)) {
            if (directionIndex > directions.length - 1) {
                directionIndex = 0
            }
            val nextDirection = directions.elementAt(directionIndex)
            val nextNodeName = currentNode.goNext(nextDirection)
            currentNode = network[nextNodeName]!!
            directionIndex += 1
            steps += 1
        }
        return steps
    }

    private fun findLCMO(numbers: List<Long>): Long {
        return numbers.reduce { lcm, element -> (lcm * element) / findGCD(lcm, element) }
    }

    private fun findGCD(a: Long, b: Long): Long {
        var num1 = a
        var num2 = b
        while (num2 != 0L) {
            val temp = num2
            num2 = num1 % num2
            num1 = temp
        }
        return num1
    }

    private fun parseNode(node: String, routes: String): Node {
        val (left, right) = routes.dropLast(1).split(", ")
        return Node(node, left, right)
    }

    data class Node(val name: String, val left: String, val right: String) {
        fun goNext(direction: Char): String {
            return when (direction) {
                'L' -> left
                'R' -> right
                else -> throw IllegalArgumentException("Wrong direction")
            }
        }

        fun isEndNode(suffix: String): Boolean {
            return name.endsWith(suffix)
        }
    }


}
