package com.atlantbh.doublelinkedlist.v2;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class DoubleLinkedListTest {

    private List<Integer> list = new DoubleLinkedList<>();

    @Test
    public void size() {
        list.add(1);
        Assert.assertEquals(1, list.size());
        Assert.assertNotEquals(0, list.size());
    }

    @Test
    public void isEmpty() {
        list.add(1);
        list.add(2);
        list.add(3);
        Assert.assertEquals(3, list.size());
        list.clear();
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void contains() {
        list.add(1);
        Assert.assertTrue(list.contains(1));
        Assert.assertFalse(list.contains(2));
    }

    @Test
    public void add() {
        list.add(1);
        Assert.assertTrue(list.contains(1));
    }

    @Test
    public void remove() {
        list.add(1);
        Integer o = 1;
        Assert.assertTrue(list.contains(o));
        list.remove(o);
        Assert.assertFalse(list.contains(o));
    }

    @Test
    public void clear() {
        list.add(1);
        Assert.assertEquals(1, list.size());
        list.clear();
        Assert.assertEquals(0, list.size());
    }

    @Test
    public void get() {
        list.add(1);
        list.add(2);
        list.add(3);
        Assert.assertEquals(Integer.valueOf(1), list.get(0));
        Assert.assertEquals(Integer.valueOf(2), list.get(1));
        Assert.assertEquals(Integer.valueOf(3), list.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getIndexOutOfBoundException() {
        Integer o = list.get(0);
    }

    @Test
    public void indexOf() {
        list.add(1);
        Assert.assertEquals(0, list.indexOf(1));
    }

    @Test
    public void lastIndexOf() {
        list.add(1);
        list.add(2);
        list.add(1);
        Assert.assertEquals(2, list.lastIndexOf(1));
    }
}