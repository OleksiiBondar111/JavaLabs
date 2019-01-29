package com.bonolex.JavaBasic.lesson_5;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class LinkedQueueTest {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();

        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

//        for (Object o : arrayList) {
//            System.out.println(o);
//        }


        for (Iterator iterator = arrayList.iterator(); iterator.hasNext(); ) {
            Object o = iterator.next();
            System.out.println(o);
        }

        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object o = iterator.next();
            System.out.println(o);
        }


        RandomGenerator randomGenerator = new RandomGenerator();
        for (Object randomValue : randomGenerator) {
            System.out.println(randomValue);
        }
    }
}

class RandomGenerator implements Iterable {
    private static final Random RANDOM = new Random();

    public int generate() {
        return RANDOM.nextInt(10);
    }

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator{
        int count;

        @Override
        public boolean hasNext() {
            return count < 10;
        }

        @Override
        public Object next() {
            count++;
            return generate();
        }

        @Override
        public void remove() {

        }
    }
}