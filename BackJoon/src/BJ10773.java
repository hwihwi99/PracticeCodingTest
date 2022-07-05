import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.util.Stack;

public class BJ10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<K; i++) {
            int N = Integer.parseInt(br.readLine());
            if(N == 0)
                stack.pop();
            else
                stack.push(N);
        }

        long answer = 0;
        for(int s : stack) {
            answer += s;
        }
        System.out.println(answer);
    }
}
