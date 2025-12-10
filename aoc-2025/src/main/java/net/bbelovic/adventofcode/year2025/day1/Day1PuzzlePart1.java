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

        Gatherer.Integrator<PuzzleState, Rotation, Integer> integratorPart1 =
                (state, element, result) ->
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

        Gatherer.Integrator<PuzzleState, Rotation, Integer> integratorPart2 =
                (state, element, result) ->
                {
                    if (Objects.equals(element.direction, "L")) {
                        int newValue = (state.dialValue - element.distance) % 100;
                        if (newValue < 0)
                            newValue += 100;
                        if (newValue > state.dialValue || newValue == 0)
                            result.push(1);
                        state.dialValue = newValue;
                    } else {
                        int newValue = (state.dialValue + element.distance) % 100;
                        if (newValue < state.dialValue || newValue == 0) {
                            result.push(1);
                        }
                        state.dialValue = newValue;
                    }
                    return true;
                };

        return inputs.stream()
                .map(s -> new Rotation(s.substring(0, 1),
                Integer.parseInt(s.substring(1))))
                .gather(Gatherer.ofSequential(PuzzleState::new, integratorPart2))
                .count();
    }
}
