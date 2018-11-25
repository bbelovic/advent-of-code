package net.bbelovic.adventofcode.day1

object InstructionProcessor {
    fun process(instruction: String, previous: Position): Position {
        var actualPosition = previous
        val directionCode = instruction.first()
        val steps = instruction.substring(1).toInt()
        actualPosition = when (directionCode) {
            'L' -> actualPosition turn Direction.Left moveBy steps
            'R' -> actualPosition turn Direction.Right moveBy steps
            else -> throw IllegalArgumentException("Unknown instruction: [$instruction]")
        }
        return actualPosition
    }
}