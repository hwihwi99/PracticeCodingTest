import java.util.ArrayList;

interface DQ<T>{
    public void offerFirst(T data);
    public void offerLast(T data);
    public T pollFirst();
    public T pollLast();
    public T peekFirst();
    public T peekLast();

}
public class Dequeue<T> implements DQ<T>{
    ArrayList<T> array = new ArrayList<>();

    @Override
    public void offerFirst(T data) {
        array.add(0,data);
    }

    @Override
    public void offerLast(T data) {
        array.add(array.size(),data);
    }

    @Override
    public T pollFirst() {
        return array.remove(0);
    }

    @Override
    public T pollLast() {
        return array.remove(array.size()-1);
    }

    @Override
    public T peekFirst() {
        return array.get(0);
    }

    @Override
    public T peekLast() {
        return array.get(array.size()-1);
    }
}
