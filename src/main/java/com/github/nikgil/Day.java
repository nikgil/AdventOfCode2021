package com.github.nikgil;

public abstract class Day {

    private final int day;

    public Day(int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public abstract void solvePart1(String[] input);

    public abstract void solvePart2(String[] input);
}
