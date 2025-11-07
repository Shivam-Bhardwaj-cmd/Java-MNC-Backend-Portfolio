package day30;

public class RatInMaze {

    static int N;

    public static boolean solveMaze(int[][] maze) {
        N = maze.length;
        int[][] sol = new int[N][N];
        if (solveMazeUtil(maze, 0, 0, sol) == false) {
            System.out.println("No solution exists");
            return false;
        }
        printSolution(sol);
        return true;
    }

    static boolean solveMazeUtil(int[][] maze, int x, int y, int[][] sol) {
        if (x == N - 1 && y == N - 1 && maze[x][y] == 1) {
            sol[x][y] = 1;
            return true;
        }

        if (isSafe(maze, x, y)) {
            sol[x][y] = 1;

            // Move forward in x direction
            if (solveMazeUtil(maze, x + 1, y, sol))
                return true;

            // Move down in y direction
            if (solveMazeUtil(maze, x, y + 1, sol))
                return true;

            // BACKTRACK
            sol[x][y] = 0;
            return false;
        }

        return false;
    }

    static boolean isSafe(int[][] maze, int x, int y) {
        return (x >= 0 && y >= 0 && x < N && y < N && maze[x][y] == 1);
    }

    static void printSolution(int[][] sol) {
        System.out.println("Path (1 = path, 0 = blocked):");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(sol[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };

        solveMaze(maze);
    }
}
