package com.code.thread.container.copyonwrite;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListTest {

    public static void main(String[] args) {
        CopyOnWriteArrayList copyOnWriteArrayList=new CopyOnWriteArrayList();
        copyOnWriteArrayList.add("A");
        copyOnWriteArrayList.add("B");
        copyOnWriteArrayList.get(0);
        copyOnWriteArrayList.remove("A");
        copyOnWriteArrayList.remove(0);
        copyOnWriteArrayList.size();
    }
}
