package edu.project2;

import java.util.LinkedList;
import java.util.Queue;

public class BFSSolver {
    public static int[][] findPath(int[][] maze, int[] start, int[] end) {
        if (maze[start[0]][start[1]] == 1 || maze[end[0]][end[1]] == 1){
            return null;
        }
        int rows = maze.length;
        int cols = maze[0].length;

        if (start[1] >= cols || end[1] >= cols) {
            return null;
        }

        boolean[][] visited = new boolean[rows][cols];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (x == end[0] && y == end[1]) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols &&
                    maze[newX][newY] == 0 && !visited[newX][newY]) {
                    queue.add(new int[] {newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }

        if (!visited[end[0]][end[1]]) {
            return null;
        }

        int[][] path = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                path[i][j] = visited[i][j] ? 2 : maze[i][j];
            }
        }

        return path;
    }
}
