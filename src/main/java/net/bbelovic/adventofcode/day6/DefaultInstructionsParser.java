package net.bbelovic.adventofcode.day6;

final class DefaultInstructionsParser<T> {

    private static final String INSTRUCTIONS_SEPARATOR = " ";
    private static final String COORDINATES_SEPARATOR = ",";
    private static final int START_COORDINATES_INDEX = 2;
    private static final int END_COORDINATES_INDEX = 4;
    private static final int START_COORDINATES_INDEX_2 = 1;
    private static final int END_COORDINATES_INDEX_2 = 3;
    private static final String TURN_INSTRUCTION_KEYWORD = "on";
    private static final int TURN_ON_OFF_INSTRUCTION_INDEX = 5;
    private static final int TURN_INSTRUCTION_INDEX = 1;
    private final OperationParser<T> operationParser;

    DefaultInstructionsParser(OperationParser<T> operationParser) {
        this.operationParser = operationParser;
    }

    Instructions<T> parseInstructions(String line) {
        String[] parts = line.split(INSTRUCTIONS_SEPARATOR);
        if (parts.length == TURN_ON_OFF_INSTRUCTION_INDEX) {
            if (TURN_INSTRUCTION_KEYWORD.equals(parts[TURN_INSTRUCTION_INDEX])) {
                return getInstructions("TURN_ON", parts[START_COORDINATES_INDEX], parts[END_COORDINATES_INDEX]);
            } else {
                return getInstructions("TURN_OFF", parts[START_COORDINATES_INDEX], parts[END_COORDINATES_INDEX]);
            }
        } else {
            return getInstructions("TOOGLE", parts[START_COORDINATES_INDEX_2], parts[END_COORDINATES_INDEX_2]);
        }
    }

    private Instructions<T> getInstructions(String operationAsString,  String startCoordinates,
                                         String endCoordinates) {
        var coords1 = startCoordinates.split(COORDINATES_SEPARATOR);
        var coords2 = endCoordinates.split(COORDINATES_SEPARATOR);
        Operation<T> operation = operationParser.parse(operationAsString);
        return new Instructions<>(operation,
                Integer.parseInt(coords1[0]),
                Integer.parseInt(coords1[1]),
                Integer.parseInt(coords2[0]), Integer.parseInt(coords2[1]));
    }
}
