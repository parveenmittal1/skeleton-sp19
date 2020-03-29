package es.datastructur.synthesizer;

import java.util.Iterator;

//Note: This file will not compile until you complete task 1 (BoundedQueue).
public class GuitarString {
    /** Constants. Do not change. In case you're curious, the keyword final
     * means the values cannot be changed at runtime. */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    private BoundedQueue<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        BoundedQueue<Double> temp=new ArrayRingBuffer((int)Math.round(SR/frequency));
        setBuffer(temp);
        //  Create a buffer with capacity = SR / frequency. You'll need to
        //       cast the result of this division operation into an int. For
        //       better accuracy, use the Math.round() function before casting.
        //       Your buffer should be initially filled with zeros.
        Iterator<Double> It=buffer.iterator();

        while(buffer.isFull()){
            temp.enqueue(0.0);
        }
    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        //  Dequeue everything in buffer, and replace with random numbers
        //       between -0.5 and 0.5. You can get such a number by using:
        //       double r = Math.random() - 0.5;
        while (!buffer.isEmpty()){
            buffer.dequeue();
        }
        while (buffer.isFull()){
            double r = Math.random() - 0.5;
            buffer.enqueue(r);
        }
        //
        //       Make sure that your random numbers are different from each
        //       other.
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm.
     */
    public void tic() {
        // Dequeue the front sample and enqueue a new sample that is
        //       the average of the two multiplied by the DECAY factor.
        //       Do not call StdAudio.play().
        if(buffer.isEmpty()){
            return;
        }
        double temp=buffer.dequeue();
        double newDouble=DECAY*((temp+buffer.peek())/2);
        buffer.enqueue(newDouble);
        return;
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        // Return the correct thing.
       if(!buffer.isEmpty()){
        return buffer.peek();}
       return 0.0;
    }

    public BoundedQueue<Double> getBuffer() {
        return buffer;
    }

    public void setBuffer(BoundedQueue<Double> buffer) {
        this.buffer = buffer;
    }
}
    // Remove all comments that say  when you're done.
