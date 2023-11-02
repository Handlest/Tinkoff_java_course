package edu.hw3.task7;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Comparator;
import java.util.TreeMap;

public class Task7Test {
    @Test
    @DisplayName("Test if null in treeMap")
    public void test1() {

        TreeMap<String, String> tree = new TreeMap<>(new NullComparator<>(Comparator.naturalOrder()));

        tree.put(null, "test");

        Assertions.assertThat(tree).containsKey(null);
    }
}
