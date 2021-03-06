import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int []juice = new int [N+1];
        int []dp = new int [N+1];

        for(int i = 1; i<=N;i++)
            juice[i] = Integer.parseInt(br.readLine());

        dp[1] = juice[1];
        if(N >= 2)
            dp[2] = juice[1]+juice[2];

        for(int i = 3; i<=N;i++){
            dp[i] = Math.max(dp[i-2]+juice[i] , dp[i-3]+juice[i-1]+juice[i]);
            dp[i] = Math.max(dp[i-1],dp[i]);
        }

        System.out.println(Math.max(dp[N-1],dp[N]));

    }
}
