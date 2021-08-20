/**
 * 이번 문제 아이디어
 *
 6

 111111
 11211
 1221

 222
 2112

 33

 양 끝이 1일 때 6-2 : => dp[i-2] 3
 양 끝이 2일 때 6-4 : => dp[i-4] 2
 양 끝이 3일 때 6-6 : => dp[i-6] 1

 ->  dp[i] = (dp[i-2]+dp[i-4]+dp[i-6]) % 1000000009

 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ15991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TestCase = Integer.parseInt(br.readLine());

        long dp[] = new long [100001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 2;
        dp[4] = 3;
        dp[5] = 3;
        dp[6] = 6;

        for(int i = 7;i<dp.length;i++){
            dp[i] = (dp[i-2]+dp[i-4]+dp[i-6]) % 1000000009;
        }


        for(int i = 0; i<TestCase;i++){
            int N = Integer.parseInt(br.readLine());
            System.out.println(dp[N]);
        }
    }
}
