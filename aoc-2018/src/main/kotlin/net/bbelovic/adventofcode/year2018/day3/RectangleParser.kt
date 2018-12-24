package net.bbelovic.adventofcode.year2018.day3

class RectangleParser {
    fun parse(input: String): Rectangle {
        val regex = """#(\d+) @ (\d+),(\d+): (\d+)x(\d+)""".toRegex()
        return try {
            val (id, x, y, width, height) = regex.matchEntire(input)!!.destructured
            Rectangle(id.toInt(), x.toInt() + 1, y.toInt() + 1, width.toInt(), height.toInt())
        } catch (e: NullPointerException) {
            throw IllegalArgumentException("Unable to parse rectangle from input: [$input]")
        }
    }
}
