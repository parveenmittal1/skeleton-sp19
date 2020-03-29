package es.datastructur.synthesizer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

// Make sure to that this class and all of its methods are public
// Make sure to add the override tag for all overridden methods
// Make sure to make this class implement BoundedQueue<T>

public class ArrayRingBuffer<T> implements BoundedQueue<T>  {
    /* Index for the next dequeue or peek. */
    private int first;
    /* Index for the next enqueue. */
    private int last;
    /* Variable for the fillCount. */
    private int fillCount;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        rb=(T[]) new Object[capacity];
        // Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        first=0;
        last=0;
        fillCount=0;

    }

   // @Override
    public int capacity() {
        return rb.length;
    }

    //@Override
    public int fillCount() {
        return last-first;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow").
     */
    public void enqueue(T x) {
        if(capacity()==fillCount()){
            throw new RuntimeException("Ring buffer overflow");
        }
        rb[fillCount()]=x;
        last++;
        //  Enqueue the item. Don't forget to increase fillCount and update
        //       last.
        return;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    public T dequeue() {
        T temp=rb[first];
        first++;
        return temp;

        //  Dequeue the first item. Don't forget to decrease fillCount and
        //       update first.
       // return null;
    }

    /**
     * Return oldest item, but don't remove it. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    public T peek() {
        // Return the first item. None of your instance variables should
        //       change.
        return rb[first];
    }
    public Iterator<T> iterator(){

        return null ;
    }

    private class RingIterator implements Iterator{

        @Override
        public boolean hasNext() {
            return fillCount>0;
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
        return first == that.first &&
                last == that.last &&
                fillCount == that.fillCount &&
                Arrays.equals(rb, that.rb);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(first, last, fillCount);
        result = 31 * result + Arrays.hashCode(rb);
        return result;
    }


    // When you get to part 4, implement the needed code to support
    //       iteration and equals.
}
    // Remove all comments that say  when you're done.
