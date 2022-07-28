package com.zipcodewilmington.singlylinkedlist;

public class LinkedListMergeSort<T extends Comparable<T>> {

    public LinkedListMergeSort() {
    }

    /** Returns left node if list is even **/
    private Node<T> findMiddleNode(Node<T> node) {
        if (node == null || node.next == null) {
            return null;
        }

        Node<T> slow = node;
        Node<T> fast = node;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node<T> mergeSort(Node<T> node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node<T> mid = findMiddleNode(node);
        Node<T> midPlusOne = mid.next;
        mid.next = null;

        Node<T> left = mergeSort(node);
        Node<T> right = mergeSort(midPlusOne);

        return merge(left, right);
    }

    // TODO - Generic merge can only properly compare number values
    private Node<T> merge(Node<T> left, Node<T> right) {
        Node<T> res;

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }

        if (left.item.compareTo(right.item) <= 0) {
            res = left;
            res.next = merge(left.next, right);
        } else {
            res = right;
            res.next = merge(left, right.next);
        }
        return res;
    }

}
