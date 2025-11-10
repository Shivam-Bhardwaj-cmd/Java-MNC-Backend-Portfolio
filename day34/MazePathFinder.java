package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class MazePathFinder {

    public static void main(String[] args) {
        int n = 3, m = 3;
        List<String> allPaths = findPaths("", n, m);
        System.out.println("All possible paths from start to end:");
        for (String path : allPaths) {
            System.out.println(path);
        }
    }

    static List<String> findPaths(String path, int row, int col) {
        List<String> paths = new ArrayList<>();

        if (row == 1 && col == 1) {
            paths.add(path);
            return paths;
        }

        // Move Down
        if (row > 1) {
            paths.addAll(findPaths(path + "D", row - 1, col));
        }

        // Move Right
        if (col > 1) {
            paths.addAll(findPaths(path + "R", row, col - 1));
        }

        return paths;
    }
}
