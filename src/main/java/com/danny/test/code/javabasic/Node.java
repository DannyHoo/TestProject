package com.danny.test.code.javabasic;

/**
 * @author huyuyang@lxfintech.com
 * @Title: Node
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-08-23 17:05:21
 */
public class Node<K, V> {
    private K key;
    private V value;
    public Node next;

    public Node() {
    }

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public boolean hasNext() {
        return next != null;
    }

    public K getKey() {
        return key;
    }

    public Node setKey(K key) {
        this.key = key;
        return this;
    }

    public V getValue() {
        return value;
    }

    public Node setValue(V value) {
        this.value = value;
        return this;
    }

    public Node getNext() {
        return next;
    }

    public Node setNext(Node next) {
        this.next = next;
        return this;
    }
}
