public class SingleCircularListNode{
    
    int data;
    SingleCircularListNode next;

    public SingleCircularListNode(int data){
        this.data = data;
        this.next = this;
    }
}