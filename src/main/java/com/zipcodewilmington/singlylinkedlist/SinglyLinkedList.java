package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T> {
    static final class Node<T> {
        T item;
        Node<T> next;

        public Node(T item) {
            this.item = item;
            this.next = null;
        }
        public Node() {
        }
    }

    private Node<T> head;

    public SinglyLinkedList() {
        head = null;
    }

    public Node<T> getListHead() {
        return head;
    }

    public void add(T item) {
        Node<T> node = new Node(item);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tmp = head;
        head = node;
        head.next = tmp;
    }

    public void append(T item) {
        Node<T> node = new Node<>(item);
        this.append(node);
    }

    public void append(Node<T> node) {
        if (head == null) {
            head = node;
            return;
        }

        if (head.next == null) {
            head.next = node;
            return;
        }

        // traverse linked list
        Node<T> tail = head.next;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public Node<T> get(int index) {
        int count = 0;
        if (head == null) {
            return null;
        }

        Node<T> node = head;
        while (node != null || count <= index) {
            if (count == index) {
                return node;
            }
            node = node.next;
            count++;
        }
        return null;
    }

    public int size() {
        int count = 0;
        for (Node<T> node = head; node != null; node = node.next) {
            count++;
        }
        return count;
    }

    public int find(T item) {
        Node<T> node = head;
        int index = 0;
        while (node != null) {
            if (node.item == item || node.item.equals(item)) {
                return index;
            }
            index++;
            node = node.next;
        }
        return -1;
    }

    public boolean contains(T item) {
        return this.find(item) > -1;
    }

    public void remove(int index) {
        Node<T> node = head;
        Node<T> prev = null;
        int count = 0;
        if (index == 0) {
            head = head.next;
            return;
        }
        while (node != null && count < index) {
            prev = node;
            node = node.next;
            count++;
        }
        prev.next = prev.next.next;
    }

    /** Deep copy of linked list **/
    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> deepCopy = new SinglyLinkedList<>();

        for (Node<T> node = head; node != null; node = node.next) {
            deepCopy.append(new Node<>(node.item));
        }
        return deepCopy;
    }

    /** Merge sort **/
    public void sort() {
    }

    public void reverse() {
        if (head == null || head.next == null) {
            return;
        }

        Node<T> headCopy = head;
        Node<T> reverse = null;
        while (headCopy != null) {
            Node<T> second = headCopy.next;
            headCopy.next = reverse;
            reverse = headCopy;
            headCopy = second;

        }
        head = reverse;
    }


}
