public class StackList{

    private StackNode top;

    public StackList(){
        this.top = null;
    }

    public boolean isEmpty(){
        return this.top == null;
    }

    public void push(int data){
        StackNode newnode = new StackNode(data);
        if(this.top == null){
            this.top = newnode;
        }else{
            newnode.next = this.top;
            this.top = newnode;
        }
        System.out.println("Successfully pushed "+data+" inside stack!!!");
    }

    public void pop(){
        int data;
        if(this.top == null){
            System.out.println("Stack is empty!!!");
            return;
        }else{
            data = this.top.data;
            this.top = this.top.next;
        }
        System.out.println("Successfully popped "+data+" inside stack!!!");
    }

    public void peek(){
        int data;
        if(this.top == null){
            System.out.println("Stack is empty!!!");
            return;
        }else{
            data = this.top.data;
        }
        System.out.println("Successfully peeked "+data+" inside stack!!!");
    }

    public static void main(String[] args) {
        StackList sa = new StackList();
        sa.peek();
        sa.push(50);
        sa.push(30);
        sa.push(120);
        sa.peek();
        sa.push(500);
        sa.push(890);
        sa.push(60);
        sa.pop();
        sa.peek();
    }
}