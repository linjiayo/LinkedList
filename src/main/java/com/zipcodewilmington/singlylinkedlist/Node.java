package com.zipcodewilmington.singlylinkedlist;

public class Node<T extends Comparable<T>> {
    T item;
    Node<T> next;

    public Node(T item) {
        this.item = item;
        this.next = null;
    }
    public Node() {
    }
}
