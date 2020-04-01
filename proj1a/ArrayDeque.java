public class ArrayDeque<T> implements Cs61b<T> {
    private T[] array;
    private int front;
    private int last;
    private int size;

    public ArrayDeque() {
        array =(T[]) new Object[2];
        size=0;
        front=-1;
        last=-1;
    }

    public void addFirst(T item) {
        if(size==array.length){
            resize(front,last);
            front=0;
            last=size-1;
        }
        ///return T;
         if(front==0){
            front=array.length-1;
        }
        else if(front<0){
            front=0;
            last=0;
        }
        else front--;
        array[front]=item;
        size++;
    }

    private void resize(int front, int last) {
        T [] temp=(T[])new Object[size*2];
        if(last<front){
            int j=0;
            for(int i=front;i<array.length;i++){
                temp[j]=array[i];
                j++;
            }
            for(int i=0;i<=last;i++){
                temp[j]=array[i];
                j++;
            }
        }
        else {
            int j=0;
            for(int i=front;i<=last;i++){
                temp[j]=array[i];
                j++;
            }
        }
        array=temp;
        return;
    }
    public void addLast(T item) {
        if(size==array.length){
            resize(front,last);
            front=0;
            last=size-1;
        }
        if (last < 0) {
            front = 0;
            last = 0;
        }
        if (last == array.length - 1) {
            last = 0;
        } else last++;
        array[last] = item;
        size++;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public int size() {
        return size;
    }

    public T getLast() {
        if(size==0){
            return null;
        }
        return array[last];
    }

    public T removeFirst() {
        if(size==0){
            return null;
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

    public T removeLast() {
        if(size==0){
            return null;
        }
        T x = array[last];
        size = size - 1;

        if(last==0){
            last=array.length-1;
            return x;
        }
        last--;
        return x;
    }

    public T get(int index) {
        if(size<index){
            return null;
        }
        return array[index-1];
    }
    @Override
    public void printDeque(){
        if(size==0){
            return;
        }
        if(last<front){
            for(int i=front;i<array.length;i++){

                System.out.println(array[i]);
            }
            for(int i=0;i<=last;i++){
                System.out.println(array[i]);
            }
        }
        else {
            for (int i = front; i <= last; i++) {
                System.out.println(array[i]);

            }
        }
    }


}
