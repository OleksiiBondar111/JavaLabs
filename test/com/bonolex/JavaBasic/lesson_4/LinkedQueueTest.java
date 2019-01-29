package com.bonolex.JavaBasic.lesson_4;

import org.junit.Assert;
import org.junit.Test;

public class LinkedQueueTest {

    @Test
    public void shouldEnqueueValues() {
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("A");
        linkedQueue.enqueue("B");
        linkedQueue.enqueue("C");
        Assert.assertEquals(3, linkedQueue.getSize());
    }

    @Test
    public void shouldDequeueValues() {
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("A");
        linkedQueue.enqueue("B");
        linkedQueue.enqueue("C");
        Assert.assertEquals("A", linkedQueue.dequeue());
        Assert.assertEquals("B", linkedQueue.dequeue());
        Assert.assertEquals("C", linkedQueue.dequeue());
        Assert.assertNull(linkedQueue.dequeue());
    }

    @Test
    public void shouldPeek() {
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("A");
        linkedQueue.enqueue("B");
        linkedQueue.enqueue("C");
        Assert.assertEquals("A", linkedQueue.peek());
    }

    @Test
    public void shouldRemoveAll() {
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("A");
        linkedQueue.enqueue("B");
        linkedQueue.enqueue("C");
        linkedQueue.removeAll();
        Assert.assertNull(linkedQueue.dequeue());
        Assert.assertEquals(0, linkedQueue.getSize());
    }


}
