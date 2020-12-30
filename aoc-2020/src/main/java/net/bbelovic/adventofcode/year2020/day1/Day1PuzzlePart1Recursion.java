package net.bbelovic.adventofcode.year2020.day1;

import net.bbelovic.adventofcode.Puzzle;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day1PuzzlePart1Recursion implements Puzzle<List<String>, Long> {

    private volatile boolean found = false;
    private List<Integer> result;

    void combinationUtil(int[] arr, int[] data, int start,
                                int end, int index, int r)
    {
        // Current combination is ready to be printed, print it
        if (index == r || found)
        {
            long sum = 0L;
            for (int j=0; j<r; j++)
                sum += data[j];

            if (sum == 2020L) {
                found = true;
                result = Arrays.stream(data).boxed().collect(Collectors.toList());
            }
            return;
        }

        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        for (int i=start; (i<=end && end-i+1 >= r-index); i++)
        {
            if (found)
                break;
            data[index] = arr[i];
            combinationUtil(arr, data, i+1, end, index+1, r);
        }
    }

    @Override
    public Long solve(List<String> input) {
        int [] arr = input.stream()
                .mapToInt(Integer::parseInt)
                .toArray();
        int [] data = new int[2];
        combinationUtil(arr, data, 0, arr.length - 1, 0, 2);

        return (long) result.stream().reduce(1, (left, right) -> left * right);

//        return null;
    }
}
