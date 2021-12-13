package com.github.nikgil.utils;

import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class InputUtils {

    private InputUtils() {}

    public static int[][] toIntGrid(String[] input) {
        int[][] grid = new int[input.length][input[0].length()];

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                grid[i][j] = input[i].charAt(j) - '0';
            }
        }

        return grid;
    }

    public static boolean isGridSpaceValid(int[] coord, int[][] grid, Optional<BiPredicate<int[], int[][]>> otherConditions) {
        int i = coord[0];
        int j = coord[1];

        if(i < 0 || i >= grid.length) {
            return false;
        }

        if(j < 0 || j >= grid[i].length) {
            return false;
        }

        return otherConditions.orElse((var1, var2) -> true).test(coord, grid);
    }
}
