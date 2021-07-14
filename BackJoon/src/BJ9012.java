import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        while (num-- > 0){

            Stack <Character> stack = new Stack<>();
            String str =br.readLine();
            boolean flag = true;

            char [] input = str.toCharArray();
            for(int j = 0;j<input.length;j++){

                if(input[j] == '('){
                    stack.push('(');
                }

                else if(input[j]==')'){
                    if(stack.isEmpty()){
                        flag = false;
                        break;
                    }else{
                        stack.pop();
                    }
                }
            }

            if(!stack.isEmpty()){
                flag = false;
            }

            if(flag)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
