package net.bbelovic.adventofcode.day6;

final class InstructionsParser {

    private static final String COORDINATE_SEPARATOR = ",";

    Instructions parseInstructions(String line) {
        String[] parts = line.split(" ");
        if (parts.length == 5) {
            return getInstructions(parts[2], parts[4]);
        } else {
            return getInstructions(parts[1], parts[3]);
        }
    }

    private Instructions getInstructions(String firstCoordinates, String secondCoordinates) {
        var coords1 = firstCoordinates.split(COORDINATE_SEPARATOR);
        var coords2 = secondCoordinates.split(COORDINATE_SEPARATOR);
        return new Instructions(
                Integer.parseInt(coords1[0]),
                Integer.parseInt(coords1[1]),
                Integer.parseInt(coords2[0]), Integer.parseInt(coords2[1]));
    }
}
