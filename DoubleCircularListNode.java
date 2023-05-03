public class DoubleCircularListNode {
    int data;
    DoubleCircularListNode next;
    DoubleCircularListNode prev;

    public DoubleCircularListNode(int data){
        this.data = data;
        this.next = this;
        this.prev = this;
    }
}
