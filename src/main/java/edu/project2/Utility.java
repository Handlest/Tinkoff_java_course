package edu.project2;

public class Utility {

    private Utility() {

    }

    public static boolean validateCoordinates(int[][] maze, int startX, int startY, int endX, int endY) {
        int rows = maze.length;
        int cols = maze[0].length;
        return startX > 0 && startY > 0 && endX > 0 && endY > 0 && startY < cols && endY < cols && startX < rows
            && endX < rows;
    }
}
