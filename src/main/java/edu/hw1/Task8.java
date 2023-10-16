package edu.hw1;

public class Task8 {

    private static final int GRID_SIZE = 8;
    private static final int POSSIBLE_MOVES_AMOUNT = 8;

    private static final int[][] POSSIBLE_MOVES = {
        {-1, 2}, {1, 2},
        {-2, 1}, {2, 1},
        {-2, -1}, {2, -1},
        {-1, -2}, {1, -2}
    };

    private Task8() {
    }

    public static boolean knightBoardCapture(int[][] board) {
        for (int x = 0; x < GRID_SIZE; x++) {
            for (int y = 0; y < GRID_SIZE; y++) {
                if (board[x][y] == 1 && isAttacking(board, x, y)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isAttacking(int[][] board, int x, int y) {

        for (int i = 0; i < POSSIBLE_MOVES_AMOUNT; i++) {
            int newX = x + POSSIBLE_MOVES[i][0];
            int newY = y + POSSIBLE_MOVES[i][1];
            if (newX < 0 || newY < 0 || newX >= GRID_SIZE || newY >= GRID_SIZE) {
                continue;
            }
            if (board[newX][newY] == 1) {
                return true;
            }
        }
        return false;
    }
}
