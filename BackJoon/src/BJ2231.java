import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BJ2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 1; i<N; i++) {
            int temp = i;
            int inputNum = i;
            while(inputNum > 0) {
                temp += inputNum % 10;
                inputNum /= 10;
            }
            if(temp == N){
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}
