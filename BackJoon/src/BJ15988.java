/**
 * 1,2,3 더하기 3
 *
 * 이는 패캠 강의 오늘 문제 푸는 곳과 같다.
 *
 * 4를 먼저 예로 들어보자
 * 그리고 모든 더하기의 조합을 두고 봤을 때 뒤에가 1, 2, 3으로 끝나는 경우를 각각 나눠서 생각해보자
 *
 * part 1) 끝이 1
 *      1 1 1 1
 *      1 2 1
 *      2 1 1
 *      3 1
 *  -> 총 합 3 만들기 (i-1)
 *
 * part 2) 끝이 2
 *      1 1 2
 *      2 2
 * -> 총 합 2 만들기 (i-2)
 *
 * part 3) 끝이 3
 *      1 3
 * -> 총 합 1 만들기 (i-3)
 *
 *  dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
 *  -> 즉 배열의 범위를 벗어나지 않게 하기 위해선 3까지는 값을 알고 있어야해요.
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ15988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TestCase = Integer.parseInt(br.readLine());

        long [] dp = new long [1000001];

        // 1,2,3 인 경우는 모두 노가다로 표현을 해줍시다!
        dp[1] =1;
        dp[2] =2;
        dp[3] =4;

        for(int i =4; i<dp.length;i++){
            dp[i] = (dp[i-1] + dp[i-2] + dp[i-3])%1000000009;
        }

        for(int i = 0;i<TestCase;i++){
            int N = Integer.parseInt(br.readLine());
            System.out.println(dp[N]);
        }
    }
}
