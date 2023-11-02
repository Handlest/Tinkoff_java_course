package edu.hw3.task8;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task8Test {
    @Test
    @DisplayName("ArrayList<Integer> of 1,2,3")
    public void test1() {
        ArrayList<Integer> firstArray = new ArrayList<>(Arrays.asList(1,2,3));
        ArrayList<Integer> resultArray = new ArrayList<>();
        BackwardIterator<Integer> backwardIterator = new BackwardIterator<>(firstArray);

        while (backwardIterator.hasNext()) {
            resultArray.add(backwardIterator.next());
        }
        Assertions.assertThat(resultArray).containsExactly(3, 2, 1);
    }

    @Test
    @DisplayName("Exception when out of range")
    public void test2() {
        ArrayList<Integer> firstArray = new ArrayList<>(Arrays.asList(1,2,3));
        ArrayList<Integer> resultArray = new ArrayList<>();
        BackwardIterator<Integer> backwardIterator = new BackwardIterator<>(firstArray);

        while (backwardIterator.hasNext()) {
            resultArray.add(backwardIterator.next());
        }
        assertThrows(NoSuchElementException.class, ()-> resultArray.add(backwardIterator.next()));
    }
}
