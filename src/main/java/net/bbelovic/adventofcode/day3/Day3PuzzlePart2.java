package net.bbelovic.adventofcode.day3;

import java.util.HashMap;
import java.util.Map;

class Day3PuzzlePart2 {
    private static final long VISITED_LOCATION = 1L;

    long solve(String input) {
        char[] chars = input.toCharArray();
        int [] realSantaCoords = {0, 0};
        int [] robotSantaCoords = {0, 0};

        Map<ArrayWrapper, Long> result = new HashMap<>();
        result.merge(new ArrayWrapper(realSantaCoords), VISITED_LOCATION, (oldValue, value)-> oldValue + VISITED_LOCATION);
        result.merge(new ArrayWrapper(robotSantaCoords), VISITED_LOCATION, (oldValue, value)-> oldValue + VISITED_LOCATION);
        for (int i = 0; i < chars.length; i = i + 2) {
            trackVisitedPositions(chars[i], realSantaCoords, result);
            trackVisitedPositions(chars[i + 1], robotSantaCoords, result);
        }
        return result.size();
    }

    private void trackVisitedPositions(char c, int[] coordinates, Map<ArrayWrapper, Long> result) {
        if (c == '^') {
            coordinates[1] = coordinates[1] + 1;
        } else if (c == '>') {
            coordinates[0] = coordinates[0] + 1;
        } else if (c == 'v') {
            coordinates[1] = coordinates[1] - 1;
        } else if (c == '<') {
            coordinates[0] = coordinates[0] - 1;
        }
        ArrayWrapper actualPosition = new ArrayWrapper(coordinates);
        result.merge(actualPosition, VISITED_LOCATION, (oldValue, value)-> oldValue + VISITED_LOCATION);
    }
}