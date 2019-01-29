package com.bonolex.JavaBasic.lesson_4;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayQueue implements Iterable {
    private Object[] array;
    private int size;
    private int queueSize;
    private int firstElementMarker;
    private int lastElementMarker;

    public ArrayQueue(int queueSize) {
        array = new Object[queueSize];
        this.queueSize = queueSize;
        this.firstElementMarker = 0;
        this.lastElementMarker = -1;
    }

    @Override
    public Iterator iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator {
        int count;

        @Override
        public boolean hasNext() {
            return count < size;
        }

        @Override
        public Object next() {
            Object value = null;
            if (hasNext()) {
                value = array[count];
                count++;
            }
            return value;
        }

        @Override
        public void remove() {

        }
    }

    void enqueue(Object value) {
        if (this.lastElementMarker == this.queueSize - 1) {
            this.lastElementMarker = -1;
        }
        array[++lastElementMarker] = value;
        this.size++;
    }

    // get and remove
    Object dequeue() {
        Object temp = this.array[this.firstElementMarker++];
        if (this.firstElementMarker == this.queueSize) {
            this.firstElementMarker = 0;
        }
        this.size--;
        return temp;
    }

    // get
    Object peek() {
        return this.array[this.firstElementMarker];
    }

    int size() {
        return this.size;
    }

    void removeAll(Object value) {
        Object[] bufArray = this.array.clone();
        this.array = new Object[this.size];
        this.size = 0;
        this.firstElementMarker = 0;
        this.lastElementMarker = -1;
        for (int i = 0; i < bufArray.length; i++) {
            if (bufArray[i] != value) {
                this.enqueue(bufArray[i]);
            }
        }
    }


}

class QueueTest {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        ArrayList a = new ArrayList();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("A");
        queue.dequeue();
        for (Object o : queue) {
            System.out.println(o);
        }
    }
}