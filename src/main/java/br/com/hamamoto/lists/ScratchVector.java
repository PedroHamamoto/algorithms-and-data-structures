package br.com.hamamoto.lists;

import java.util.Iterator;
import java.util.stream.Stream;

public class ScratchVector<T> implements ScratchList<T>
{
    public static final int EXTRA_COMMA_THRESHOLD = 2;
    private int current;
    private Object[] data;

    public ScratchVector(int initialSize) {
        current = 0;
        data = new Object[initialSize];
    }

    public ScratchVector() {
        this(10);
    }

    @Override
    public void add(T item) {
        if (data.length == current) {
            this.grow();
        }

        data[current++] = item;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) data[index];
    }

    @Override
    public void remove(int index) {
        checkIndex(index);

        if (index != current) {
            shift(index);
        }

        current--;
    }

    @Override
    public int size() {
        return current;
    }

    private void shift(int index) {
        for (int i = index; i < current; i++) {
            data[i] = data[i + 1];
        }
    }

    private void checkIndex(int index) {
        if (index >= current) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void grow() {
        var newSize = data.length * 2;
        var newData = new Object[newSize];

        System.arraycopy(data, 0, newData, 0, data.length);

        data = newData;
    }

    @Override
    public Iterator iterator() {
        return Stream.of(data).iterator();
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < size(); i++) {
            sb.append(data[i]).append(", ");
        }

        if (sb.length() > EXTRA_COMMA_THRESHOLD) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }

        sb.append("]");

        return sb.toString();
    }
}
