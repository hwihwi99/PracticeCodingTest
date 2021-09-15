import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue <Integer> queue = new LinkedList<>();
        for(int i = 0;i<N;i++){
            queue.offer(i+1);
        }
        while(--N>0){
            queue.poll();
            int temp = queue.poll();
            queue.offer(temp);
        }
        System.out.println(queue.peek());
    }
}
