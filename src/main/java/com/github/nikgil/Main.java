package com.github.nikgil;

import com.github.nikgil.days.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private final static Map<Integer, Day> days;

    static {
        days = new HashMap<>();
        addDays();
    }

    public static void main(String[] args) {
        int date = days.size();

        if(args.length > 0) {
            date = Integer.parseInt(args[0]);
        }

        Day targetDay = days.get(date);

        if(targetDay == null) {
            System.err.printf("Day %d not found!%n", date);
            return;
        }

        try {
            String[] input = parseDateFile(date);

            System.out.println("Part 1: ");
            targetDay.solvePart1(input);
            System.out.println("\n=====\nPart 2: ");
            targetDay.solvePart2(input);
        } catch(IOException e) {
            System.err.printf("Day input file for day %d not found!%n", date);
        }
    }

    private static String[] parseDateFile(int date) throws IOException {
        String path = String.format("Day%d.txt", date);
        Path p = Paths.get("src", "main", "resources", path);
        List<String> lst = Files.readAllLines(p);

        return lst.toArray(new String[0]);
    }

    private static void addDays() {
        days.put(12, new Day12());
        days.put(11, new Day11());
        days.put(10, new Day10());
        days.put(9, new Day9());
        days.put(8, new Day8());
        days.put(7, new Day7());
        days.put(6, new Day6());
        days.put(5, new Day5());
        days.put(4, new Day4());
        days.put(3, new Day3());
        days.put(2, new Day2());
        days.put(1, new Day1());
    }
}
