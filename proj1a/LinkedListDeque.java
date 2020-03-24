public class LinkedListDeque<t> implements Cs61b {

    private class ListNode<T>{
        T value;
        ListNode first;
        ListNode Last;

        ListNode(ListNode a,T val,ListNode b){
            value=val;
            first=a;
            Last=b;
        }
    }

    private ListNode sentinalNode;
    int size;

    public LinkedListDeque(){
        sentinalNode=new ListNode(null,null,null);
    }

    public LinkedListDeque(t item){
        sentinalNode=new ListNode(null,null,null);
        sentinalNode.Last=new ListNode(sentinalNode,item,null);
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
        sentinalNode.Last=helperDeep(other.sentinalNode.Last,sentinalNode.Last);
    }

    private t helpIndex(int index, ListNode first){
        if(index==0){
            return (t) first.value;
        }
        return (t) helpIndex(index-1,first.Last);
    }

    public t getRecursive(int index){
        if(index==0){
            return (t) null;
        }
        return (t) helpIndex(index,sentinalNode.Last);
    }

    @Override
    public void addFirst(t item) {
        ListNode newNode=new ListNode(null,item,null);
        ListNode temp=sentinalNode.Last;
        sentinalNode.Last=newNode;
        newNode.Last=temp;
        size++;
    }

    @Override
    public void addLast(Object item) {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void printDeque() {

    }

    @Override
    public Object removeFirst() {
        return null;
    }

    @Override
    public Object removeLast() {
        return null;
    }

    @Override
    public Object get(int index) {
        return null;
    }

}
