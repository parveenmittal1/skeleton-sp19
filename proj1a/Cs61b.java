public interface Cs61b<T> {
    public void addFirst(T item);
    public void addLast(T item);
    public boolean isEmpty();
    public int size();
    public T removeFirst();
    public T removeLast();
    public T get(int index);
    public default void printDeque(){
        int temp=size();
        for(int i=0;i<temp;i++)
        System.out.println(get(i));
    }
}
