package com.atlantbh.doublelinkedlist.v1.impl;

import com.atlantbh.doublelinkedlist.v1.DoubleLinkedList;

import java.util.*;

/**
 * Implementation of Double Linked List by use of custom interface
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

    @Override
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

    @Override
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

    @Override
    public void removeFirstElement() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        head = head.next;
        head.previous = null;
        size--;
    }

    @Override
    public void removeLastElement() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        tail = tail.previous;
        tail.next = null;
        size--;
    }

    @Override
    public void iterateBackward() {
        Node iter = tail;
        while (iter != null) {
            System.out.println(iter.element.toString());
            iter = iter.previous;
        }
    }

    @Override
    public void iterateForward() {
        Node iter = head;
        while (iter != null) {
            System.out.println(iter.element.toString());
            iter = iter.next;
        }
    }

    public void addElementBeforeNode(E element, Node<E> targetNode) {
        if (targetNode == null) {
            throw new NoSuchElementException();
        }
        Node<E> previous = targetNode.previous;
        Node node = new Node(previous, targetNode, element);
        targetNode.previous = node;
        if (previous == null) {
            head = node;
        } else {
            previous.next = node;
        }
        size++;
    }

    public void addElementAfterNode(E element, Node<E> targetNode) {
        if (targetNode == null) {
            throw new NoSuchElementException();
        }
        Node<E> next = targetNode.next;
        Node node = new Node(targetNode, next, element);
        targetNode.next = node;
        if (next == null) {
            tail = node;
        } else {
            next.previous = node;
        }
        size++;
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


