import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BJ1927 {
    private static ArrayList<Integer> min_heap = null;

    public static boolean moved_up(int index){
        if(index <= 1)
            return false;
        int parent_idx = index / 2;
        if(min_heap.get(parent_idx) > min_heap.get(index))
            return true;
        return false;
    }

    public static void insert(int num){
        // 첫번째 삽입이면 1번째 인덱스부터 값을 넣어야하기 때문에
        if(min_heap == null){
            min_heap = new ArrayList<>();
            min_heap.add(0);
            min_heap.add(num);
        }else{
            // 현재 넣은 곳은 인덱스와 그 부모 인덱스
            int insert_idx, parent_idx;
            min_heap.add(num);
            insert_idx = min_heap.size()-1;
            while(moved_up(insert_idx)){
                parent_idx = insert_idx / 2;
                Collections.swap(min_heap, parent_idx, insert_idx);
                insert_idx = parent_idx;
            }
        }
    }

    public static boolean moved_down(int index){
        int left_child_pop_index,right_child_pop_index;
        left_child_pop_index = index* 2;
        right_child_pop_index = index * 2 + 1;

        // case 1 : 왼쪽 자식 노드가 없을 때 == 자식 노드가 없을 때
        if(left_child_pop_index >= min_heap.size())
            return false;
        // case 2 : 오른쪽 자식 노드만 없을 때 == 왼쪽 자식만 있을 때
        else if (right_child_pop_index>=min_heap.size()){
            if(min_heap.get(index)>min_heap.get(left_child_pop_index))
                return true;
            else
                return false;
        }
        // csae 3 : 자식이 두개 다 있을 때
        else {
            // 왼쪽 자식이 더 클 때
            if(min_heap.get(left_child_pop_index)> min_heap.get(right_child_pop_index)){
                // 그럼 오른쪽과 부모를 비교해
                if(min_heap.get(index) > min_heap.get(right_child_pop_index)){
                    // 오른쪽이 더 작으면 이게 루트로 가야지!
                    return true;
                }
                else
                    return false;
            }
            // 오른쪽 자식이 더 클 때
            else if(min_heap.get(left_child_pop_index)< min_heap.get(right_child_pop_index)){
                // 그럼 왼쪽과 부모를 비교해
                if(min_heap.get(index) > min_heap.get(left_child_pop_index)){
                    // 왼쪽이 더 작으면 이게 루트로 가야지!
                    return true;
                }
                else
                    return false;
            }
        }
        return false;
    }

    public static int popMin(){
        if(min_heap == null || min_heap.size() == 1){
            return 0;
        }
        int returnData = min_heap.get(1);
        min_heap.set(1,min_heap.get(min_heap.size()-1));
        min_heap.remove(min_heap.size()-1);
        int pop_idx = 1;
        int left_child_pop_idx, right_child_pop_idx;
        while(moved_down(pop_idx)){
            left_child_pop_idx = pop_idx * 2;
            right_child_pop_idx = pop_idx * 2 + 1;

            // 왼쪽 자식은 있고 오른쪽 자식은 없을 때
            if(right_child_pop_idx>=min_heap.size()){
                if(min_heap.get(left_child_pop_idx) < min_heap.get(pop_idx)){
                    Collections.swap(min_heap,left_child_pop_idx,pop_idx);
                    pop_idx = left_child_pop_idx;
                }else {
                    if(min_heap.get(left_child_pop_idx) > min_heap.get(right_child_pop_idx)){
                        if(min_heap.get(pop_idx) > min_heap.get(right_child_pop_idx)){
                            Collections.swap(min_heap,pop_idx, right_child_pop_idx);
                            pop_idx = right_child_pop_idx;
                        }
                    }
                    else if (min_heap.get(left_child_pop_idx) < min_heap.get(right_child_pop_idx)){
                        if(min_heap.get(pop_idx) < min_heap.get(left_child_pop_idx)){
                            Collections.swap(min_heap,pop_idx,left_child_pop_idx);
                            pop_idx = left_child_pop_idx;
                        }
                    }
                }
            }

        }
        return returnData;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        for(int i = 0;i<num;i++){
            int input = Integer.parseInt(br.readLine());
            if(input == 0){
                builder.append(popMin()).append('\n');
            }else{
                insert(input);
            }
        }
        System.out.println(builder.toString());
    }
}
