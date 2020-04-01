import org.jetbrains.annotations.NotNull;
import org.w3c.dom.NodeList;

import java.util.LinkedList;
import java.util.List;

public class LinkedListDeque<T> implements Cs61b<T> {

    private class ListNode{
        ListNode last;
        T value;
        ListNode next;

        ListNode(ListNode b,T val,ListNode a){
            last=b;
            value=val;
            next=a;
        }
    }



    private ListNode front;
    private ListNode rear;
    private int size;



    public LinkedListDeque(){
        front=null;
        rear=null;
        size=0;
    }
    public LinkedListDeque(T item){
        front=new ListNode(null,item,null);
        rear=front;
        size=1;
    }
    private  void helperDeep(LinkedListDeque src, LinkedListDeque ans){
        if(src.front==null){
            ans.rear= null;
        }
        ListNode temp=src.front;
        while(temp!=null){
            if(ans.front==null){
                ans.front =new ListNode(null,temp.value,null);
                ans.rear=ans.front;
            }
        ans.rear.next =new ListNode(ans.rear,temp.value,null);
        temp=temp.next;
        }
        return ;
    }

    public  LinkedListDeque(LinkedListDeque other){
        helperDeep(other, this);
    }
    
    private T helpIndex(int index, ListNode first,LinkedListDeque src){
        if(index==0){
            return  first.value;
        }
        return (T) helpIndex(index-1,src.rear,src);
    }

    public T getRecursive(int index){
        if(index==0){
            return  null;
        }
        return helpIndex(index-1,this.front,this);
    }




    public void addFirst(T item) {
        if(item==null){
            throw new NullPointerException("You are adding null");
        }
        if(this.front==null){
            front=new ListNode(null,item,null);
            rear=front;
            size++;
            return;
        }
        ListNode temp =new ListNode(rear,item,front);
        rear.next=temp;
        front.last=temp;
        front=temp;
        size++;
    }


    public void addLast(T item) {
       if(size==0){
           addFirst(item);
       }
       rear.next=new ListNode(rear,item,front);
       rear=rear.next;
       size++;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if(size==0)
        {
            return;
        }
        ListNode temp=front;
        System.out.print(temp.value+" ");
        ListNode temp2=temp;
        temp=temp.next;
        while (temp!=temp2){
            System.out.print(temp.value+" ");
            temp=temp.next;
        }
    }

    public T removeFirst() {

        if(front==null){
            return null;
        }
        T temp=front.value;

        front=front.next;
        rear.next=front;
        front.last=rear;
        size--;
        return temp;
    }

    public T removeLast() {
        if(size==0){
            return null;
        }
        T temp=rear.value;
        rear=rear.last;
        rear.next=front;
        front.last=rear;
        size--;
        return temp;
    }
    public T getLast() {
        if(size==0){
            return null;
        }
        return rear.value;
    }

    public T get(int index) {
        if(index>size){
            return null;
        }
        if(index==0){
            return null;
        }
        return helpIndex(index-1,this.front,this);
    }
    public static void main(String[] args) {
        LinkedListDeque<Integer> temp=new LinkedListDeque();
        System.out.println(temp.size());
        System.out.println(temp.getLast());
        System.out.println(temp.get(3));
        System.out.println(temp.removeLast());
        System.out.println(temp.removeFirst());
        System.out.println(temp.isEmpty());
        temp.printDeque();
        temp.addFirst(6);
        temp.addFirst(5);
        temp.addFirst(4);
        temp.addFirst(3);
        temp.addFirst(2);
        temp.addFirst(1);
        temp.addLast(7);
        temp.addLast(8);
        System.out.println(temp.removeFirst());
        System.out.println(temp.removeFirst());
        System.out.println(temp.removeFirst());
        temp.addLast(9);
        temp.addLast(10);
        temp.addLast(11);
        temp.addFirst(3);
        temp.addFirst(2);
        temp.addFirst(1);
        System.out.println(temp.removeLast());
        System.out.println(temp.removeLast());
        System.out.println(temp.removeLast());
        System.out.println(temp.removeLast());
        System.out.println(temp.removeLast());
        System.out.println(temp.removeLast());
        temp.printDeque();
    }


}
