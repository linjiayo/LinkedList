package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {
    SinglyLinkedList<String> linkedList;
    String[] str = new String[] { "1", "2", "3", "4"};

    @BeforeEach
    void testConstructor() {
        linkedList = new SinglyLinkedList<>();
    }
    @Test
    void add() {
        String str1 = "test";
        String expected = "test2";

        linkedList.add(str1);
        linkedList.add(expected);

        String actual = linkedList.getListHead().item;

        Assert.assertEquals(expected, actual);
    }

    @Test
    void append() {
        String str1  = "test";
        String str2 = "test2";
        String expected = "test3";

        linkedList.append(str1);
        linkedList.append(str2);
        linkedList.append(expected);

        String actual = linkedList.get(linkedList.size() -1).item;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSize() {
        for (String s : str) {
            linkedList.add(s);
        }
        Integer expected = 4;

        Integer actual = linkedList.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFind() {
        for (String s : str) {
            linkedList.append(s);
        }
        Integer expectedPresent = 2;
        Integer expectedNotPresent = -1;

        Integer actualPresent = linkedList.find("3");
        Integer actualNotPresent = linkedList.find("One");

        Assert.assertEquals(expectedPresent, actualPresent);
        Assert.assertEquals(expectedNotPresent, actualNotPresent);
    }
    @Test
    public void testRemoveHead() {
        for (String s : str) {
            linkedList.append(s);
        }

        linkedList.remove(0);

        Assertions.assertEquals(3, linkedList.size());
    }

    @Test
    public void testRemoveMiddle() {
        for (String s : str) {
            linkedList.append(s);
        }

        linkedList.remove(1);
        Integer expectedIndex = -1;

        String actual = linkedList.get(1).item;
        Integer actualIndex = linkedList.find("2");

        Assert.assertEquals("3", actual);
        Assert.assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void testRemoveLast() {
        for (String s : str) {
            linkedList.append(s);
        }
        linkedList.remove(3);

        Integer expectedIndex = -1;

        Integer actualIndex = linkedList.find("4");

        Assert.assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void testContains() {
        for (String s : str) {
            linkedList.append(s);
        }

        Boolean expectedFound = true;
        Boolean expectedNoItem = false;

        Boolean actualFound = linkedList.contains("1");
        Boolean actualNoItem = linkedList.contains("0");

        Assert.assertEquals(expectedFound, actualFound);
        Assert.assertEquals(expectedNoItem, actualNoItem);
    }

    @Test
    public void testDeepCopy() {
        for (String s : str) {
            linkedList.append(s);
        }

        SinglyLinkedList<String> copy = linkedList.copy();
        String expectedFirst = "1";
        String expectedLast = "4";

        String actualFirst = copy.get(0).item;
        String actualLast = copy.get(copy.size() -1).item;


        Assert.assertNotEquals(linkedList, copy);
        Assert.assertEquals(expectedFirst, actualFirst);
        Assert.assertEquals(expectedLast, actualLast);
    }

    @Test
    public void testReverse() {
        for (String s : str) {
            linkedList.append(s);
        }
        SinglyLinkedList<String> rev = linkedList.copy();
        rev.reverse();

        for (int i = 0; i < linkedList.size(); i++) {
            Assert.assertEquals(linkedList.get(i).item, rev.get(linkedList.size() - i - 1).item);
        }
    }


}
