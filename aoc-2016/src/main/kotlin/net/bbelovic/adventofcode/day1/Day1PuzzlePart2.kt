package net.bbelovic.adventofcode.day1

class Day1PuzzlePart2 : AbstractDay1Puzzle() {

    override fun processInstructions(list: List<String>): Point {
        var actualPosition = Position(orientation = Point(0, 1))
        val allVisitedPoints = hashSetOf(actualPosition.value)
        for (instruction in list) {
            actualPosition = InstructionProcessor.process(instruction, actualPosition)
            val visitedPoints = actualPosition.visitedPoints
            for (point in visitedPoints) {
                if (point in allVisitedPoints) {
                    return point
                } else {
                    allVisitedPoints.add(point)
                }
            }
        }
        throw IllegalStateException("Expected at least one position visited twice.")
    }
}