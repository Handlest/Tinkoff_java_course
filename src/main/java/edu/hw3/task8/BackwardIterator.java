package edu.hw3.task8;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

public class BackwardIterator<T> implements Iterator<T> {

    private final T[] collectionElements;
    private int currentIndex;

    @SuppressWarnings("unchecked")
    public BackwardIterator(@NotNull Collection<T> collection) {
        this.collectionElements = (T[]) collection.toArray();
        this.currentIndex = collectionElements.length - 1;
    }

    @Override
    public boolean hasNext() {
        return currentIndex >= 0;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return collectionElements[currentIndex--];
    }
}
