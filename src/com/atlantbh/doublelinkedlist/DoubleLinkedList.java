package com.atlantbh.doublelinkedlist;

/**
 * Note that best practice would be to implement List<E> interface.
 * Since I am restricted with time I will define my own interface and implement standard functionalities
 * Future Work: Implement List<E> interface
 * @param <E>
 */
public interface DoubleLinkedList<E> {
    int size();
    boolean isEmpty();
    void addFirstElement(E element);
    void addLastElement(E element);
    void removeFirstElement();
    void removeLastElement();
    void iterateBackward();
    void iterateForward();
}
