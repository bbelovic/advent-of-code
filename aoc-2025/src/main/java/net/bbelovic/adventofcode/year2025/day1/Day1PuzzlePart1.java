package net.bbelovic.adventofcode.year2025.day1;

import java.util.List;
import java.util.Objects;
import java.util.stream.Gatherer;

class Day1PuzzlePart1 {

    long solve(List<String> inputs) {

        record Rotation(String direction, int distance) {}
        class PuzzleState {
            int dialValue = 50;
        }

        Gatherer.Integrator<PuzzleState, Rotation, Integer> integrator = (state, element, result) ->
        {
            if (Objects.equals(element.direction, "L")) {
                state.dialValue = (state.dialValue - element.distance) % 100;
            } else {
                state.dialValue = (state.dialValue + element.distance) % 100;
            }
            if (state.dialValue < 0)
                state.dialValue = state.dialValue + 100;
            if (state.dialValue == 0)
                result.push(1);
            return true;
        };

        Gatherer.Integrator<Integer, Rotation, Integer> integrator2 = (state, element, result) ->
        {
            if (Objects.equals(element.direction, "L")) {
                state = (state - element.distance) % 100;
            } else {
                state = (state + element.distance) % 100;
            }
            if (state < 0)
                state = state + 100;
            if (state == 0)
                result.push(1);
            return true;
        };



        return inputs.stream()
                .map(s -> new Rotation(s.substring(0, 1),
                Integer.parseInt(s.substring(1))))
                .gather(Gatherer.ofSequential(PuzzleState::new, integrator))
                .count();


    }
}
