package edu.project2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Project2Test {
    @Test
    @DisplayName("Проверка работы алгоритма BFS")
    void FindPathWithBFS() {
        Generator generator = new SimpleGenerator(10, 10, 1);
        int[][] maze = generator.generate();
        int[] start = {1, 1};
        int[] end = {8, 1};
        int[][] solvedMaze = BFSSolver.findPath(maze, start, end);
        SimplePrettyRenderer.printMaze(maze);
        assertThat(solvedMaze).isNotNull();
        SimplePrettyRenderer.printMaze(solvedMaze);
    }

    @Test
    @DisplayName("Проверка работы рекурсивного алгоритма поиска")
    void FindPathWithRecursion() {
        Generator generator = new SimpleGenerator(10, 10, 1);
        int[][] maze = generator.generate();
        int[] start = {1, 1};
        int[] end = {8, 1};
        int[][] solvedMaze = RecusiveSolver.findPath(maze, start[0], start[1], end[0], end[1]);
        SimplePrettyRenderer.printMaze(maze);
        assertThat(solvedMaze).isNotNull();
        SimplePrettyRenderer.printMaze(solvedMaze);
    }

    @Test
    @DisplayName("Неверно переданные параметры")
    void CheckNull() {
        Generator generator = new SimpleGenerator(10, 10, 1);
        int[][] maze = generator.generate();
        int[] start = {0, 0}; // Стена
        int[] end = {8, 1};
        int[][] solvedMaze = BFSSolver.findPath(maze, start, end);
        SimplePrettyRenderer.printMaze(maze);
        assertThat(solvedMaze).isNull();
    }
}
