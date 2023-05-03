package Stack;

public class StackArray {
    
    int top = 0;
    int[] arr = null;

    public StackArray(int size){
        this.top = -1;
        arr = new int[size];
    }

    public boolean isEmpty(){
        return this.top == -1;
    }

    public boolean isFull(){
        return this.top + 1 == arr.length;
    }

    public void push(int data){
        if(isFull()){
            System.out.println("Stack is full!!!");
        }else{
            arr[++this.top] = data;
        }
    }

    public int pop(){
        int data = 0;
        if(isEmpty()){
            System.out.println("Stack is empty!!!");
        }else{
            data = arr[this.top--];
        }
        return data;
    }

    public void peek(){
        if(isEmpty()){
            System.out.println("Stack is empty!!!");
        }else{
            System.out.println("Current Peek : "+arr[this.top]);
        }
    }

    public static void main(String[] args) {
        StackArray sa = new StackArray(5);
        sa.peek();
        sa.push(50);
        sa.push(30);
        sa.push(120);
        sa.peek();
        sa.push(500);
        sa.push(890);
        sa.push(060);
        System.out.println("Element removed : "+sa.pop());
        sa.peek();
    }
}
