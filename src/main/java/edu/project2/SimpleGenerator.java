package edu.project2;

import java.util.Random;

public class SimpleGenerator implements Generator {
    Random random;
    private int width;
    private int height;
    private int[][] maze;

    public SimpleGenerator(int width, int height, int seed) {
        this.width = width / 2;
        this.height = height / 2;
        this.maze = new int[2 * width][2 * height];
        this.random = new Random(seed);
    }

    public int[][] generate() {
        generateMaze();
        return this.maze;
    }

    private void generateMaze() {
        for (int i = 0; i < 2 * width + 1; i++) {
            for (int j = 0; j < 2 * height + 1; j++) {
                maze[i][j] = 1;
            }
        }

        int startX = random.nextInt(width);
        int startY = random.nextInt(height);

        maze[2 * startX + 1][2 * startY + 1] = 0; // Открываем стартовую ячейку

        createPath(2 * startX + 1, 2 * startY + 1);
    }

    @SuppressWarnings("MagicNumber")
    private void createPath(int x, int y) {
        int[] dx = {0, 0, 2, -2};
        int[] dy = {2, -2, 0, 0};

        int[] directions = {0, 1, 2, 3};
        shuffleArray(directions);

        for (int direction : directions) {
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if (nx > 0 && ny > 0 && nx < 2 * width && ny < 2 * height && maze[nx][ny] == 1) {
                maze[nx][ny] = 0; // Открываем проход
                maze[x + dx[direction] / 2][y + dy[direction] / 2] = 0;
                createPath(nx, ny);
            }
        }
    }

    private void shuffleArray(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }

}
