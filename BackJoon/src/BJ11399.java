import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int []input = new int [num];
        int []dp = new int [num];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 0;i<num;i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        dp[0] = input[0];
        int sum = dp[0];
        for(int i = 1;i<num;i++) {
            dp[i] = dp[i-1]+input[i];
            sum += dp[i];
        }
        System.out.println(sum);
    }
}
