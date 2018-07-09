package net.bbelovic.adventofcode.day6;

final class InstructionsParser {
    public Instructions parseInstructions(String line) {
        String[] parts = line.split(" ");
        if (parts.length == 5) {
            var coords1Part = parts[2];
            var coords2Part= parts[4];
            var coords1 = coords1Part.split(",");
            var coords2 = coords2Part.split(",");
            return new Instructions(
                    Integer.parseInt(coords1[0]),
                    Integer.parseInt(coords1[1]),
                    Integer.parseInt(coords2[0]), Integer.parseInt(coords2[1]));
        }
        return new Instructions(0, 0, 0, 0);
    }
}
