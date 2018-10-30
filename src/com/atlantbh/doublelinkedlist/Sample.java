package com.atlantbh.doublelinkedlist;

import com.atlantbh.doublelinkedlist.impl.DoubleLinkedList;
import com.atlantbh.doublelinkedlist.impl.DoubleLinkedListImpl;

import java.util.List;

public class Sample {

    public static void main(String[] args){
        List<Integer> list = new DoubleLinkedList<>();
        list.add(1);
        list.add(2);
        System.out.println(list.size());
        System.out.println(list.get(0));
        System.out.println(list.get(1));
    }

}
