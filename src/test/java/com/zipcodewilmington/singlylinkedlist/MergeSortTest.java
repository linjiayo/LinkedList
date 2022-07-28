package com.zipcodewilmington.singlylinkedlist;

import com.sun.scenario.effect.Merge;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    void mergeSort() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        LinkedListMergeSort<Integer> sorter = new LinkedListMergeSort<>();
        list.setListHead(sorter.mergeSort(list.getListHead()));

        for (int i = 0; i < list.size(); i++) {
            Integer expectedItem = i;
            Node<Integer> actualNode = list.get(i);

            Assertions.assertEquals(expectedItem, actualNode.item);
        }
    }
}