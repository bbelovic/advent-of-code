package net.bbelovic.adventofcode.day3;

import net.bbelovic.adventofcode.InputReader;
import org.junit.jupiter.params.ParameterizedTest;

class Day3PuzzleMainTest {
    @ParameterizedTest
    void should_solve_puzzle() {
        InputReader reader = new InputReader();
        String input = reader.readFileIntoString("input3.txt");
        Day3Puzzle day3Puzzle = new Day3Puzzle();
        System.out.println(day3Puzzle.getLocationVisitedOnce(input));
        System.out.println(day3Puzzle.getLocationVisitedOnceTwoSantas(input));

    }

}
