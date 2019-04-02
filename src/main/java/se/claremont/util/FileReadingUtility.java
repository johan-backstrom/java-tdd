package se.claremont.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReadingUtility {

    public static List<String> readFileLinesFromResources(String filename) {

        Scanner fileScanner = new Scanner(
                FileReadingUtility.class
                        .getClassLoader()
                        .getResourceAsStream(filename)
        );

        List<String> fileRows = new ArrayList<>();

        while (fileScanner.hasNextLine()) {
            fileRows.add(fileScanner.nextLine());
        }

        return fileRows;
    }
}
