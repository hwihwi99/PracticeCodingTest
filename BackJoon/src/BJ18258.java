import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ18258{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0 ; i<N; i++) {
            String cmd = br.readLine();
            if(cmd.contains("push")) {
                StringTokenizer st = new StringTokenizer(cmd," ");
                st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                queue.offer(num);
            }else if(cmd.equals("pop")){
                if(queue.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(queue.poll()).append("\n");
            }else if(cmd.equals("size")) {
                sb.append(queue.size()).append("\n");
            }else if(cmd.equals("empty")) {
                if(queue.isEmpty())
                    sb.append(1).append("\n");
                else
                    sb.append(0).append("\n");
            }else if(cmd.equals("front")){
                if(queue.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(queue.getFirst()).append("\n");
            }else if(cmd.equals("back")) {
                if(queue.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(queue.getLast()).append("\n");
            }
        }
        System.out.println(sb);
    }
}