package br.com.hamamoto.lists;

public interface ScratchList<T> extends Iterable{

    void add(T item);
    T get(int index);
    void remove(int index);
    int size();
}
