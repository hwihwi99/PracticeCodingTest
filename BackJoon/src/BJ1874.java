import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class BJ1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> stack = new ArrayList<>();
        stack.add(0,0);
        int top = 0; // 제일 꼭대기를 가리킴
        int index = 1; // 다음으로 넣어야할 숫자
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(stack.get(top) > num) {
                flag = false;
                break;
            }
            while (stack.get(top) < num) {
                stack.add(top+1,index);
                top++;
                index++;
                sb.append("+").append("\n");
            }

            if(stack.get(top) == num) {
                stack.remove(top);
                top--;
                sb.append("-").append("\n");
            }
        }
        if(!flag){
            System.out.println("NO");
        }else {
            System.out.println(sb);
        }
    }
}