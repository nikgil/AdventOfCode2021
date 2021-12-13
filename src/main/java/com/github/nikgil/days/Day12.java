package com.github.nikgil.days;

import com.github.nikgil.Day;
import com.github.nikgil.utils.StringUtils;

import java.util.*;

public class Day12 extends Day {
    public Day12() {
        super(12);
    }

    Map<String, List<String>> nodes;

    @Override
    public void solvePart1(String[] input) {
        nodes = getMap(input);
        List<List<String>> paths = new ArrayList<>();

        getPaths(nodes, new HashSet<>(Collections.singleton("start")), "start", new ArrayList<>(Collections.singleton("start")), paths);

        System.out.println(paths.size());
    }

    @Override
    public void solvePart2(String[] input) {
        List<List<String>> paths = new ArrayList<>();
        Map<String, Integer> traversed = new HashMap<>();
        traversed.put("start", 2);
        getPaths2(nodes, traversed, "start", new ArrayList<>(Collections.singleton("start")), paths, false);

        System.out.println(paths.size());
    }

    private static Map<String, List<String>> getMap(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s : paths) {
            String[] split = s.split("-");

            map.putIfAbsent(split[0], new ArrayList<>());
            map.putIfAbsent(split[1], new ArrayList<>());

            map.get(split[0]).add(split[1]);
            map.get(split[1]).add(split[0]);
        }

        return map;
    }

    private static void getPaths(Map<String, List<String>> map, Set<String> traversed, String cur, List<String> cache, List<List<String>> master) {
        if(cur.equals("end")) {
            master.add(new ArrayList<>(cache));
            return;
        }

        for(String dir : map.get(cur)) {
            if(traversed.contains(dir)) {
                continue;
            }

            if(StringUtils.toLowerCase(dir).equals(dir)) {
                traversed.add(dir);
            }

            cache.add(dir);

            getPaths(map, traversed, dir, cache, master);

            cache.remove(cache.size()-1);

            traversed.remove(dir);
        }
    }

    private static void getPaths2(Map<String, List<String>> map, Map<String, Integer> traversed, String cur, List<String> cache, List<List<String>> master, boolean hasTwo) {
        if(cur.equals("end")) {
            master.add(new ArrayList<>(cache));
            return;
        }

        for(String dir : map.get(cur)) {
            if(traversed.getOrDefault(dir, 0) > 1) {
                continue;
            }

            if(traversed.getOrDefault(dir, 0) == 1) {
                if(hasTwo) {
                    continue;
                }
            }

            if(StringUtils.toLowerCase(dir).equals(dir)) {
                traversed.put(dir, traversed.getOrDefault(dir, 0) + 1);
            }

            cache.add(dir);

            getPaths2(map, traversed, dir, cache, master, traversed.getOrDefault(dir, 0) == 2 || hasTwo);

            cache.remove(cache.size()-1);

            traversed.put(dir, traversed.getOrDefault(dir, 0) - 1);
        }
    }
}