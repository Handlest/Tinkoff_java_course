package edu.project2;

public class RecusiveSolver {
    public static int[][] findPath(int[][] maze, int startX, int startY, int endX, int endY) {
        int[][] solution = new int[maze.length][maze[0].length];
        for (int i = 0; i < solution.length; i++) {
            System.arraycopy(maze[i], 0, solution[i], 0, solution[0].length);
        }
        boolean found = findPathPrivate(solution, startX, startY, endX, endY);
        if (found) {
            solution[startX][startY] = 2;
            solution[endX][endY] = 2;
            return solution;
        } else {
            return null;
        }
    }

    private static boolean findPathPrivate(int[][] solution, int row, int col, int endX, int endY) {
        if (row < 0 || row >= solution.length || col < 0 || col >= solution[0].length || solution[row][col] == 1) {
            return false;
        }
        if (row == endX && col == endY) {
            return true;
        }
        solution[row][col] = 1;
        if (findPathPrivate(solution, row - 1, col, endX, endY) ||
            findPathPrivate(solution, row + 1, col, endX, endY) ||
            findPathPrivate(solution, row, col - 1, endX, endY) ||
            findPathPrivate(solution, row, col + 1, endX, endY)) {
            solution[row][col] = 2;
            return true;
        } else {
            solution[row][col] = 1;
            return false;
        }
    }
}
