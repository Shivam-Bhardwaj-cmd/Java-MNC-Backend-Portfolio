package day33;

import java.util.*;

public class RatInMazeAllPaths {

    static int N;

    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };
        List<String> paths = findPaths(maze);
        System.out.println("All possible paths from start to end: " + paths);
    }

    static List<String> findPaths(int[][] maze) {
        N = maze.length;
        List<String> result = new ArrayList<>();
        boolean[][] visited = new boolean[N][N];
        findPathsUtil(maze, 0, 0, "", visited, result);
        return result;
    }

    static void findPathsUtil(int[][] maze, int x, int y, String path, boolean[][] visited, List<String> result) {
        if (x == N - 1 && y == N - 1 && maze[x][y] == 1) {
            result.add(path);
            return;
        }

        if (isSafe(maze, x, y, visited)) {
            visited[x][y] = true;

            findPathsUtil(maze, x + 1, y, path + "D", visited, result);
            findPathsUtil(maze, x - 1, y, path + "U", visited, result);
            findPathsUtil(maze, x, y + 1, path + "R", visited, result);
            findPathsUtil(maze, x, y - 1, path + "L", visited, result);

            visited[x][y] = false; // backtrack
        }
    }

    static boolean isSafe(int[][] maze, int x, int y, boolean[][] visited) {
        return x >= 0 && y >= 0 && x < N && y < N && maze[x][y] == 1 && !visited[x][y];
    }
}
