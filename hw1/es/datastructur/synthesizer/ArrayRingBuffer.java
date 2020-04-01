package es.datastructur.synthesizer;
import com.sun.javafx.scene.control.ReadOnlyUnbackedObservableList;
import com.sun.xml.internal.fastinfoset.stax.events.ReadIterator;
import edu.princeton.cs.algs4.In;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

// Make sure to that this class and all of its methods are public
// Make sure to add the override tag for all overridden methods
// Make sure to make this class implement BoundedQueue<T>

public class ArrayRingBuffer<T> implements BoundedQueue<T>  {
    private T[] array;
    private int front;
    private int last;
    private int size;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        array =(T[]) new Object[2];
        size=0;
        front=-1;
        last=-1;
    }

   // @Override
    public int capacity() {
        return array.length;
    }

    //@Override
    public int fillCount() {
        return size;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow").
     */
    public void enqueue(T x) {
        if(size==array.length){
            throw new RuntimeException("Ring buffer overflow");
        }
        if (last < 0) {
            front = 0;
            last = 0;
        }
        if (last == array.length - 1) {
            last = 0;
        } else last++;
        array[last] = x;
        size++;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    public T dequeue() {
        if(size==0){
            throw new RuntimeException("Ring buffer underflow");
        }
        T temp=array[front];
        if(front==array.length-1){
            front=0;
            size--;
            return temp;
        }
        front++;
        size--;
        return temp;
    }

    /**
     * Return oldest item, but don't remove it. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    public T peek() {
        // Return the first item. None of your instance variables should
        //       change.
        if(size==0){
           // Double a=0.345;
           // return (T)a;
            throw new ArrayIndexOutOfBoundsException("size is zero");
        }
        return array[front];
    }
    public Iterator<T> iterator(){

        return new RingIterator();
    }

    private class RingIterator implements Iterator{

        @Override
        public boolean hasNext() {
            return size>0;
        }

        @Override
        public Object next() {
            return dequeue();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayRingBuffer<?> that = (ArrayRingBuffer<?>) o;
        return front == that.front &&
                last == that.last &&
                size == that.size&&
                Arrays.equals(array, that.array);
    }
}