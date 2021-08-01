import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());

        int isPrime;
        int result = 0;
        int count;
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i<num;i++){
            isPrime = Integer.parseInt(st.nextToken());
            count = 0;
            for(int j = 1;j<=isPrime;j++){
                if(isPrime % j == 0)
                    count++;
            }
            if(count == 2)
                result++;
        }
        System.out.println(result);
    }
}
