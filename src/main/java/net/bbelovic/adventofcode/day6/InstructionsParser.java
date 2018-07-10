package net.bbelovic.adventofcode.day6;

import java.util.function.Function;

final class InstructionsParser {

    private static final String COORDINATE_SEPARATOR = ",";
    private final Function<Boolean, Boolean> TURN_ON = (b)-> true;
    private final Function<Boolean, Boolean> TURN_OFF = (b)-> false;
    private final Function<Boolean, Boolean> TOOGLE = (b)-> !b;

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

    private Instructions getInstructions(Function<Boolean, Boolean> f,  String firstCoordinates, String secondCoordinates) {
        var coords1 = firstCoordinates.split(COORDINATE_SEPARATOR);
        var coords2 = secondCoordinates.split(COORDINATE_SEPARATOR);
        return new Instructions(f,
                Integer.parseInt(coords1[0]),
                Integer.parseInt(coords1[1]),
                Integer.parseInt(coords2[0]), Integer.parseInt(coords2[1]));
    }
}
