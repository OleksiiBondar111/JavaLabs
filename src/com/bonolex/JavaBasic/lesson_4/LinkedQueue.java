package com.bonolex.JavaBasic.lesson_4;

public class LinkedQueue {
    private Node root;
    private Node end;
    private int size;

    public LinkedQueue() {
        this.root = null;
        this.size = 0;
    }

    private class Node {
        Object value;
        Node next;
        Node previous;

        Node(Object value) {
            this.value = value;
        }
    }

    public void enqueue(Object value) {
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

    public Object dequeue() {
        if (size != 0) {
            Object value = root.value;
            root = root.next;
            size--;
            return value;
        }
        return null;
    }

    public Object peek() {

        if (size != 0) {
            return root.value;
        }
        return null;
    }

    public void removeAll() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

}
