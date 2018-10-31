package com.atlantbh.doublelinkedlist.v2;

import java.util.*;

/**
 * Double linked list implementation. It implements List<E> interface.
 * List contains an extra pointer, typically called previous pointer, together with next pointer and element.
 * <p>
 * Note that some methods are left unimplemented due to the lack of time.
 *
 * @param <E>
 * @author BattleArray61
 * @see List
 */
public class DoubleLinkedList<E> implements List<E> {

    private Node head;
    private Node tail;
    private int size;

    public DoubleLinkedList() {
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(final Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(final E e) {
        final Node tailNode = tail;
        final Node<E> newNode = new Node<>(tailNode, null, e);
        tail = newNode;
        if (tailNode == null) {
            head = newNode;
        } else {
            tailNode.next = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(final Object o) {
        for (Node<E> iter = head; iter != null; iter = iter.next) {
            if (Objects.equals(o, iter.element)) {
                removeNode(iter);
            }
        }
        return true;
    }

    private void removeNode(Node<E> iter) {
        iter.element = null;
        Node<E> next = iter.next;
        Node<E> previous = iter.previous;
        if (previous == null) {
            head = next;
        } else {
            previous.next = next;
            iter.previous = null;
        }
        if (next == null) {
            tail = next;
        } else {
            next.previous = previous;
            iter.next = null;
        }
        size--;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        size = 0;
        for (Node iterator = head; iterator != null; ) {
            Node next = iterator.next;
            iterator.previous = null;
            iterator.next = null;
            iterator.element = null;
            iterator = next;
        }
        head = null;
        tail = null;
    }

    @Override
    public E get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            Node<E> node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node.element;
        }
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, final E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else {
            Node<E> node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            if (size != 0) {
                Node<E> previous = node.previous;
                Node<E> nodeToInsert = new Node<>(previous, node, element);
                if (previous == null) {
                    head = nodeToInsert;
                } else {
                    previous.next = nodeToInsert;
                }
            } else {
                add(element);
            }
            size++;
        }
    }

    @Override
    public E remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            Node<E> node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            remove(node.element);
        }

        return null;
    }

    @Override
    public int indexOf(Object o) {
        int counter = 0;
        for (Node iterator = head; iterator != null; iterator = iterator.next) {
            if (Objects.equals(o, iterator.element)) {
                return counter;
            }
            counter++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int counter = size;
        for (Node iterator = tail; iterator != null; iterator = iterator.previous) {
            counter--;
            if (Objects.equals(o, iterator.element)) {
                return counter;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
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
