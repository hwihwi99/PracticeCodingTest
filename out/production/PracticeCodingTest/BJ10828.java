import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ10828 {
    public static void main(String[] args) throws IOException {

        Stack <Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        for(int i = 0;i<num;i++){
            st = new StringTokenizer(br.readLine()," ");

            switch (st.nextToken()){
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    if(stack.isEmpty())
                        sb.append(-1).append('\n');
                    else
                        sb.append(stack.pop()).append('\n');
                    break;

                case "size":
                    sb.append(stack.size()).append('\n');
                    break;

                case "empty":
                    if(stack.isEmpty())
                        sb.append(1).append('\n');
                    else
                        sb.append(0).append('\n');
                    break;

                case "top":
                    if(stack.isEmpty())
                        sb.append(-1).append('\n');
                    else
                        sb.append(stack.peek()).append('\n');
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
