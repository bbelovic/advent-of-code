package net.bbelovic.adventofcode.day3;

import java.util.HashMap;
import java.util.Map;

class Day3PuzzlePart1 {

    private static final long VISITED_LOCATION = 1L;

    long solve(String input) {
        Map<ArrayWrapper, Long> result = new HashMap<>();
        int [] coordinates = {0, 0};
        result.put(new ArrayWrapper(coordinates), VISITED_LOCATION);
        char[] chars = input.toCharArray();
        for (char c: chars) {
            trackVisitedPositions(c, coordinates, result);
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
