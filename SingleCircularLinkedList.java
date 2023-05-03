public class SingleCircularLinkedList {
    private SingleCircularListNode head;
    private SingleCircularListNode tail;
    int length;

    public SingleCircularLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    /**
     * insert
     * delete 
     * search 
     * treverse
     * reverse
     * @param data
     */
    public void traveseList(){
        if(this.head == null){
            System.out.println("List is empty!!!");
            return;
        }
        SingleCircularListNode current = this.head;
        while(current != null){
            System.out.print(current.data + " -> ");
            if(current == this.tail){
                break;
            }
            current = current.next;
        }
        System.out.println();
    }

    public void insert(int data, int location){
        SingleCircularListNode newnode = new SingleCircularListNode(data);
        if(this.head == null){
            this.head = newnode;
            this.tail = newnode;
        }else{
            if(location == 0){
                newnode.next = this.head;
                this.head = newnode;
                this.tail.next = this.head;
            }else if(location == this.length){
                this.tail.next = newnode;
                this.tail = this.tail.next;
                this.tail.next = this.head;
            }else{
                int index = 0;
                SingleCircularListNode current = this.head;
                while(index < location - 1){
                    index += 1;
                    current = current.next;
                }
                SingleCircularListNode nextNode = current.next;
                newnode.next = nextNode;
                current.next = newnode;
            }
        }
        this.length += 1;
        System.out.println("Successfully inserted element!!!");
    }

    public void delete(int location){
        if(this.head == null){
            System.out.println("List is empty!!!");
            return;
        }
        if(this.head == this.tail){
            this.head = null;
            this.tail = null;
        }else{
            if(location == 0){
                this.head = this.head.next;
                this.tail.next = this.head;
            }else if(location == this.length){
                SingleCircularListNode current = this.head;
                while(current.next != this.tail){
                    current = current.next;
                } 
                current.next = null;
                this.tail = current;
                this.tail.next = this.head;
            }else{
                int index = 0;
                SingleCircularListNode current = this.head;
                while(index < location - 1){
                    index += 1;
                    current = current.next;
                }
                SingleCircularListNode nextNode = current.next;
                current.next = nextNode.next;
            }
        }
        this.length -= 1;
        System.out.println("Successfully deleted element!!!");

    }

    public void search(int data){
        if(this.head == null){
            System.out.println("List is empty!!!");
            return;
        }
        SingleCircularListNode current = this.head;
        while(current != null){
            if(current.data == data){
                System.out.println("Successfully found key "+data+" in linked list!!!");
                return;
            }
            if(current == this.tail){
                break;
            }
            current = current.next;
        }
        System.out.println("Key "+data+" does not exist in linked list!!!");
    }

    public static void main(String[] args) {
        SingleCircularLinkedList list = new SingleCircularLinkedList();
        list.insert(10, 0);
        list.insert(40, list.length);
        list.insert(20, 1);
        list.insert(70, list.length);
        list.traveseList();
        list.search(90);
        list.delete(0);
        list.delete(list.length);
        list.delete(0);
        list.delete(0);
        list.traveseList();
        list.search(10);
    }
}
