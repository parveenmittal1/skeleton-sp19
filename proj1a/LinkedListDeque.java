import org.w3c.dom.NodeList;

public class LinkedListDeque<T> implements Cs61b<T> {

    private class ListNode{
        T value;
        ListNode first;
        ListNode Last;

        ListNode(ListNode a,T val,ListNode b){
            value=val;
            first=a;
            Last=b;
        }
    }



    private ListNode sentinelNode;
    private int size;



    public LinkedListDeque(){
        sentinelNode =new ListNode(null,null,null);
        size=0;
    }
    public LinkedListDeque(T item){
        sentinelNode =new ListNode(null,null,null);
        sentinelNode.Last=new ListNode(sentinelNode,item,null);
        size=1;

    }



    private  ListNode helperDeep(ListNode src,ListNode ans){
        if(src==null){
            return null;
        }
        ListNode temp=src;
        ans =new ListNode(null,temp.value,null);
        ans.Last=helperDeep(temp.Last,ans.Last);
        return ans;
    }

    public  LinkedListDeque(LinkedListDeque other){
        sentinelNode.Last=helperDeep(other.sentinelNode.Last, sentinelNode.Last);
    }




    private T helpIndex(int index, ListNode first){
        if(index==0){
            return  first.value;
        }
        return helpIndex(index-1,first.Last);
    }
    public T getRecursive(int index){
        if(index==0){
            return  null;
        }
        return helpIndex(index-1, sentinelNode.Last);
    }




    public void addFirst(T item) {
        sentinelNode.Last=new ListNode(sentinelNode,item,sentinelNode.Last);
        size++;
    }


    public void addLast(T item) {
        size = size + 1;
        ListNode p = sentinelNode;
        /* Advance p to the end of the list. */
        while (p.Last != null) {
            p = p.first;
        }
        p.first = new ListNode(p,item,null);
        size++;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        ListNode temp=sentinelNode;
        while (temp.Last!=null){
            System.out.print(sentinelNode.Last.value+" ");
            temp=temp.Last;
        }
    }

    public T removeFirst() {
        ListNode temp=sentinelNode.Last;
        sentinelNode.Last=temp.Last;
        return temp.value;
    }

    public T removeLast() {
        ListNode temp=sentinelNode;
        while (temp.Last!=null){
           // System.out.print(sentinelNode.Last.value+" ");
            temp=temp.Last;
        }
        ListNode temp2=temp;
        temp.first.Last=null;
        return temp2.value;
    }

    public T get(int index) {
        if(index==0){
            return null;
        }
        return helperGet(index,sentinelNode.Last);
    }

    private T helperGet(int index, ListNode last) {
        if(index==1){
            return last.value;
        }
        return helperGet(index-1,last.Last);
    }
}
