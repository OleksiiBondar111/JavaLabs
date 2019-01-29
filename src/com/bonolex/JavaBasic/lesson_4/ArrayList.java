package com.bonolex.JavaBasic.lesson_4;

import java.util.Iterator;

public class ArrayList implements List, Iterable {
    Object[] array;
    int size;
    private int pointer;


    public ArrayList(int size) {
        this.size = size;
        this.pointer = 0;
        this.array = new Object[size];
    }

    @Override
    public Iterator iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator {
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
            }
            count++;
            return value;
        }

        @Override
        public void remove() {
            ArrayList.this.remove(count);
            count--;
        }
    }

    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, this.pointer);
        this.array = newArray;
    }


    // in case of end of space, please grow in 1.5 times
    @Override
    public void add(Object value) {
        if (this.pointer == array.length - 1) {
            resize((int) (array.length * 1.5));
        }
        array[pointer++] = value;
    }

    @Override
    public void add(Object value, int index) {
        if (this.array.length < index) {
            throw new IndexOutOfBoundsException("The list does not contain such index");
        }
        Object[] newArray = new Object[++size];
        if (index > 0) {
            System.arraycopy(array, 0, newArray, 0, index - 1);
        }
        System.arraycopy(array, 0, newArray, index + 1, this.pointer);
        newArray[index] = value;
        this.array = newArray;
        pointer++;
    }

    @Override
    public Object remove(int index) {
        Object removed = this.array[index];
        if (this.array.length >= index) {
            for (int i = index; i < pointer; i++) {
                array[i] = array[i + 1];
            }
            array[pointer] = null;
            pointer--;
            size--;
        }
        return removed;
    }

    @Override
    public Object get(int index) {
        return this.array[index];
    }

    @Override
    public Object set(Object value, int index) {
        if (this.array.length >= index) {
            this.array[index] = value;
        }
        return this.array[index];
    }

    @Override
    public void clear() {
        this.array = new Object[this.size];
        pointer = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.array.length == 0;
    }

    @Override
    public boolean contains(Object value) {
        boolean isContains = false;
        for (Object arrayValue : this.array) {
            if (arrayValue == value) {
                isContains = true;
                break;
            }
        }
        return isContains;
    }

    @Override
    public int indexOf(Object value) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (this.array[i] == value) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(Object value) {
        int index = -1;
        for (int i = array.length - 1; i >= 0; i--) {
            if (this.array[i] == value) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        ArrayList a = new ArrayList(3);
        a.add("A");
        a.add("B");
        a.add("C");

        for (Object o : a) {
            System.out.println(o);
        }

        a.iterator().remove();
        for (Object o : a) {
            System.out.println(o);
        }
    }
}
