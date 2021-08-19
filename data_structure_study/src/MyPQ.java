import java.util.*;

public class MyPQ{
    // 오름차순을 위한
    public static class IntComparator implements Comparator{
        public int compare(Object o1, Object o2){
            return (int)o1 - (int)o2;
        }
    }

    // 오름차순을 위한
    public static class IntComparator2 implements Comparator{
        public int compare(Object o1, Object o2){
            return (int)o2 - (int)o1;
        }
    }

    private ArrayList <MyEntry> priorityQueue;
    private Comparator comparator;

    public MyPQ(){
        this.priorityQueue = null;
        this.comparator = null;
    }

    public MyPQ (Comparator comp){
        this.priorityQueue = new ArrayList<>();
        this.comparator = comp;
    }

    // 큐 내부에서 사용하는 배열의 초기 크기를 설정해준다
    public MyPQ (int initialCapacity, Comparator comp){
        priorityQueue = new ArrayList<>(initialCapacity);
        this.comparator = comp;
    }

    public int size(){
        return priorityQueue.size();
    }

    public boolean isEmpty(){
        return this.size() == 0;
    }

    // list를 계속 정렬해가면서 올바른 위치에 넣기
    public MyEntry insert(Object key, Object value){
        MyEntry newEntry = new MyEntry(key,value);

        int len = priorityQueue.size();

        // 넣어야하는 위치 찾기
        int where = 0;
        for(int i = 0; i<len; i++){
            MyEntry temp = priorityQueue.get(i);
            if(this.comparator.compare(key,temp.getkey())>0){
                where++;
            }
        }
        priorityQueue.add(where,newEntry);

        return newEntry;
    }

    // 0번째 인덱스 출력 후 삭제하기
    public MyEntry removeMin(){
        return priorityQueue.remove(0);
    }

    // 0번째 인덱스 출력
    public MyEntry min(){
        return  priorityQueue.get(0);
    }

    public static void main(String[] args) {
        IntComparator c = new IntComparator();
        MyPQ pq = new MyPQ(c);

        pq.insert(30, null);
        pq.insert(10, null);
        pq.insert(20, null);
        System.out.println(pq.min().getkey());
        System.out.println(pq.removeMin().getkey());
        System.out.println(pq.min().getkey());
        System.out.println(pq.removeMin().getkey());
        System.out.println(pq.min().getkey());
        System.out.println(pq.removeMin().getkey());
    }

}
