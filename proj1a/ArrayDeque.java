public class ArrayDeque<T> implements Cs61b<T> {
    private T[] array;
    int size;

    public ArrayDeque() {
        array =(T[]) new Object[10];
        size=0;
    }

    public void addFirst(T item) {
        ///return T;
        array[0]=item;
        size++;
    }

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(array, 0, a, 0, size);
        array = a;
    }
    public void addLast(T item) {
        if(size==array.length){
            resize(size*2);
        }
        array[size]=item;
        size++;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public int size() {
        return size;
    }

    public T getLast() {
        return array[size - 1];
    }

    public T removeFirst() {
        return null;
    }

    public T removeLast() {
        T x = getLast();
        size = size - 1;
        return x;
    }

    public T get(int index) {
        return array[index-1];
    }
}
