package net.bbelovic.adventofcode.day1

class Day1PuzzlePart1 : Day1PuzzleTemplate() {
    override fun processInstructions(list: List<String>): Point {
        var actualPosition = Position(orientation = Point(0, 1))
        for (instruction in list) {
            actualPosition = InstructionProcessor.process(instruction, actualPosition)
        }
        return actualPosition.value
    }
}