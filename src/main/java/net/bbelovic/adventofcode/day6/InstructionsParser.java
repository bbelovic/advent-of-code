package net.bbelovic.adventofcode.day6;

import static net.bbelovic.adventofcode.day6.LightOperation.*;

final class InstructionsParser {

    private static final String COORDINATE_SEPARATOR = ",";

    Instructions parseInstructions(String line) {
        String[] parts = line.split(" ");
        if (parts.length == 5) {
            if ("on".equals(parts[1])) {
                return getInstructions(TURN_ON, parts[2], parts[4]);
            } else {
                return getInstructions(TURN_OFF, parts[2], parts[4]);
            }
        } else {
            return getInstructions(TOOGLE, parts[1], parts[3]);
        }
    }

    private Instructions getInstructions(LightOperation lightOperation,  String firstCoordinates, String secondCoordinates) {
        var coords1 = firstCoordinates.split(COORDINATE_SEPARATOR);
        var coords2 = secondCoordinates.split(COORDINATE_SEPARATOR);
        return new Instructions(lightOperation,
                Integer.parseInt(coords1[0]),
                Integer.parseInt(coords1[1]),
                Integer.parseInt(coords2[0]), Integer.parseInt(coords2[1]));
    }
}
