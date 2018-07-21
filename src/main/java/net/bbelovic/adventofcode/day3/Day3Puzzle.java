package net.bbelovic.adventofcode.day3;

import net.bbelovic.adventofcode.InputReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day3Puzzle {

    private static final long VISITED_LOCATION = 1L;

    long getLocationVisitedOnce(String input) {
        Map<ArrayWrapper, Long> result = new HashMap<>();
        int [] coordinates = {0, 0};
        result.put(new ArrayWrapper(coordinates), VISITED_LOCATION);
        char[] chars = input.toCharArray();
        for (char c: chars) {
            trackVisitedPositions(c, coordinates, result);
        }
        return result.size();
    }


    long getLocationVisitedOnceTwoSantas(String input) {
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
