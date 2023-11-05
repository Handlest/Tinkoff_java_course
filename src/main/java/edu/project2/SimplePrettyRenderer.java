package edu.project2;

public class SimplePrettyRenderer implements Renderer{
    public static void printMaze(int[][] maze) {
        int height = maze[0].length;
        for (int[] ints : maze) {
            for (int j = 0; j < height; j++) {
                if (ints[j] == 0) {
                    System.out.print(" ");
                } else if (ints[j] == 2) {
                    System.out.print(".");
                } else {
                    System.out.print("#");
                }
            }
            System.out.println();
        }
    }
}
