package com.bonolex.JavaBasic.lesson_4;

import java.util.Iterator;

public class LinkedList implements List, Iterable {
    private Node root;
    private Node end;
    private int size;

    public LinkedList() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator {
        int count;
        Node node = root;

        @Override
        public boolean hasNext() {
            return count < size;
        }

        @Override
        public Object next() {
            Object value = null;
            if (hasNext()) {
                count++;
                value = node.value;
                node = node.next;
            }
            return value;
        }

        @Override
        public void remove() {
            LinkedList.this.remove(count);
            count--;
        }
    }

    private class Node {
        Object value;
        Node next;
        Node previous;

        Node(Object value) {
            this.value = value;
        }
    }

    @Override
    public void add(Object value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            end = root;
        } else {
            newNode.previous = end;
            end.next = newNode;
            end = newNode;
        }
        size++;
    }

    @Override
    public void add(Object value, int index) {
        Node newNode = new Node(value);
        Node temp = getNodeByIndex(index);// return the node before index
        newNode.previous = temp.previous;
        newNode.next = temp;
        if (index != 0) {
            temp.previous.next = newNode;
        }
        size++;
    }

    @Override
    public Object remove(int index) {
        Node l = getNodeByIndex(index);
        l.previous.next = l.next;
        if (index != size) {
            l.next.previous = l.previous;
        }
        size--;
        return l.value;
    }

    Node getNodeByIndex(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node linkedNode = root;
        for (int i = 0; i < size - 1; i++) {
            if (i == index) {
                break;// found node and exit
            }
            linkedNode = linkedNode.next;
        }
        return linkedNode;
    }


    @Override
    public Object get(int index) {
        return getNodeByIndex(index).value;
    }

    @Override
    public Object set(Object value, int index) {
        Node linkedNode = getNodeByIndex(index);
        linkedNode.value = value;

        return getNodeByIndex(index).value;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object value) {
        Node current = root;
        for (int i = 0; i < size; i++) {
            if (current.value == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int indexOf(Object value) {
        Node current = root;
        for (int i = 1; i <= size; i++) {
            if (current.value == value) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        Node current = root;
        while (current.next != null) {
            current = current.next;
        }
        for (int i = size; i <= size; i--) {
            if (current.value == value) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    public static void main(String[] args) {
//        LinkedList linkedList = new LinkedList();
////        linkedList.add("A");
////        linkedList.add("B");
////        linkedList.add("C");
////        linkedList.add("D");
////        Iterator i = linkedList.iterator();
////        while (i.hasNext()) {
////          System.out.println(i.next());
////
////        }
////        i.remove();
////        for (Object o : linkedList) {
////            System.out.println(o);
////        }
////
        Byte b =2;
        System.out.println(b<<1);


    }
}