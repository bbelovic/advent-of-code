package net.bbelovic.adventofcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InputReader {
    public List<String> readAllLines(String inputFile) {
        List<String> allLines = Collections.emptyList();
        try {
            allLines = Files.readAllLines(Paths.get("./src/main/resources/" + inputFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allLines;
    }


    public String readFileIntoString(String inputFile) {
        List<String> allLines = readAllLines(inputFile);
        return allLines.stream().collect(Collectors.joining());
    }
}
