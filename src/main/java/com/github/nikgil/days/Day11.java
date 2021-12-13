package com.github.nikgil.days;

import com.github.nikgil.Day;
import com.github.nikgil.utils.InputUtils;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class Day11 extends Day {
    public Day11() {
        super(11);
    }

    int[][] grid;

    @Override
    public void solvePart1(String[] input) {
        grid = InputUtils.toIntGrid(input);

        int iters = 100;
        long sum = 0;

        for(int i = 0; i < iters; i++) {
            sum += iterate(grid);
        }

//        for(int[] row : grid) {
//            System.out.println(Arrays.toString(row));
//        }

        System.out.println(sum);
    }

    @Override
    public void solvePart2(String[] input) {
        grid = InputUtils.toIntGrid(input);
        int steps = 0;

        while(iterate(grid) != grid.length * grid[0].length) {
            steps++;
        }

        System.out.println(steps+1);
    }

    private static int iterate(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int[] dirs = new int[]{1,0,-1};

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                grid[i][j]++;

                if(grid[i][j] == 10) {
                    queue.offer(new int[]{i,j});
                }
            }
        }

        int total = queue.size();

        while(!queue.isEmpty()) {
            int[] pos = queue.poll();

            for(int i : dirs) {
                for(int j : dirs) {
                    int x = pos[0] + i;
                    int y = pos[1] + j;

                    if(InputUtils.isGridSpaceValid(new int[]{x,y},grid, Optional.empty()) && grid[x][y] != -1) {
                        grid[x][y]++;

                        if(grid[x][y] == 10) {
                            queue.offer(new int[]{x,y});
                            total++;
                        }
                    }
                }
            }

            grid[pos[0]][pos[1]] = -1;
        }

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == -1) {
                    grid[i][j]++;
                }
            }
        }

        return total;
    }
}