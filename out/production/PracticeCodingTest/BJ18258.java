import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ18258 {
    public static void main(String[] args) throws IOException {
        Deque <Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int []arr = new int [queue.size()];
        for(int i = 0; i<num;i++){
            st = new StringTokenizer(br.readLine()," ");
            switch (st.nextToken()){

                case "push":
                    queue.offer(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    if(queue.isEmpty())
                        sb.append(-1).append('\n');
                    else
                        sb.append(queue.poll()).append('\n');
                    break;

                case "size":
                    sb.append(queue.size()).append('\n');
                    break;

                case "empty":
                    if(queue.isEmpty())
                        sb.append(1).append('\n');
                    else
                        sb.append(0).append('\n');
                    break;

                case "front":
                    if(queue.isEmpty())
                        sb.append(-1).append('\n');
                    else
                        sb.append(queue.peek()).append('\n');
                    break;
                case "back":
                    if(queue.isEmpty())
                        sb.append(-1).append('\n');
                    else
                        sb.append(queue.peekLast()).append('\n');
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
