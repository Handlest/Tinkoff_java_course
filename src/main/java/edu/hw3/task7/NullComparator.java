package edu.hw3.task7;

import java.util.Comparator;

public class NullComparator<T> implements Comparator<T> {

    private final Comparator<? super T> comparator;

    public NullComparator(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    @Override
    public int compare(T key1, T key2) {
        return key1 == null && key2 == null ? 0
            : key1 == null ? -1
            : key2 == null ? 1
            : comparator.compare(key1, key2);
    }
}
