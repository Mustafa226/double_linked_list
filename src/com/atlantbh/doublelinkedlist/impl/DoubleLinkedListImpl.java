package com.atlantbh.doublelinkedlist.impl;

import com.atlantbh.doublelinkedlist.DoubleLinkedList;

import java.util.*;

/**
 * Implementation of Double Linked List
 *
 * @param <E> the type of elements held in the List
 * @author Mustafa Mehuljic
 */
public class DoubleLinkedListImpl<E> implements DoubleLinkedList<E> {

    private Node head;
    private Node tail;
    private int size;

    public DoubleLinkedListImpl() {
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    public void addFirstElement(final E element) {
        final Node<E> first = head;
        Node node = new Node(null, head, element);
        head = node;
        if (first == null) {
            tail = node;
        } else {
            first.previous = node;
        }
        size++;
    }

    public void addLastElement(final E element) {
        final Node<E> last = tail;
        Node node = new Node(tail, null, element);
        tail = node;
        if (last == null) {
            head = node;
        } else {
            last.next = node;
        }
        size++;
    }

    public void removeFirstElement() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        head = head.next;
        head.previous = null;
        size--;
    }

    public void removeLastElement() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        tail = tail.previous;
        tail.next = null;
        size--;
    }

    private static class Node<E> {
        Node<E> previous;
        Node<E> next;
        E element;

        Node(final Node previous, Node next, E element) {
            this.previous = previous;
            this.next = next;
            this.element = element;
        }

    }

}


