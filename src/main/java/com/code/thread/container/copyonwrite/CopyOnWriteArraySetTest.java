package com.code.thread.container.copyonwrite;

import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetTest {

    public static void main(String[] args) {
        CopyOnWriteArraySet copyOnWriteArraySet=new CopyOnWriteArraySet();
        copyOnWriteArraySet.add("A");
        copyOnWriteArraySet.add("B");
        copyOnWriteArraySet.contains("A");
        copyOnWriteArraySet.remove("B");
        copyOnWriteArraySet.size();
    }
}
