package com.atlantbh.doublelinkedlist;

// FIXME: Note that best practice would be to implement List<E> interface. Since I am restricted with time I will define my own interface with some basic functionalities
// TODO: implement List<E>
public interface DoubleLinkedList<E> {
    int size();
    boolean isEmpty();
    void addFirstElement(E element);
    void addLastElement(E element);
    void removeFirstElement();
    void removeLastElement();
}
