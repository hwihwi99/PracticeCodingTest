public class Stack {
    private Object [] arr;
    private int top;

    public Stack(int size){
        arr = new Object[size];
        top = 0;
    }

    public boolean isEmpty(){
        return top == 0;
    }

    public boolean isFull(){
        return top == arr.length-1;
    }

    public void push(Object obj){
        if(!isFull())
            arr[top++] = obj;
        else
            System.out.println("Stack is full");
    }

    public Object pop(){
        if(!isEmpty())
            return arr[--top];
        else {
            System.out.println("Stack is empty");
            return null;
        }
    }
}
