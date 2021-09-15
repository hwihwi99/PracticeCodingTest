public class Queue<I extends Number> {
    private Object [] arr;
    private int head;
    private int tail;

    public Queue(int size){
        arr = new Object[size];
        head = 0;
        tail = 0;
    }

    public int size(){
        return tail - head;
    }

    public boolean isEmpty(){
        return head == tail;
    }

    public void enqueue(Object obj){
        arr[tail++] = obj;
    }

    public Object dequeue(){
        return arr[head++];
    }

}
