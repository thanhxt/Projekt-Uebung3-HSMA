package de.hsmannheim.inf.pr2.ads;

public interface ContainerList<E> extends Iterable<E> {
    boolean contains(E o);
    int size();
    default boolean isEmpty(){
        return size() == 0;
    }
    void clear();
    String toListString();
    boolean containsIter(E e);
}
