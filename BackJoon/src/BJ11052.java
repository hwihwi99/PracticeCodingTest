/**
 * DP를 이용하는 문제
 * -> 큰 문제를 작은 단위의 문제로 쪼개서 생각하는 알고리즘!
 *
 * 이 문제의 경우...
 * 카드 i개가 들어있는 것을 구매하는 방법은?
 *
 * 1개가 들어있는 카드팩 + i-1개의 카드
 * 2개가 들어있는 카드팩 + i-2개의 카드
 * 3개가 들어있는 카드팩 + i-3개의 카드
 *
 * 즉 일반화를 시키면
 * dp[i] = dp[n] + dp[i-n]
 *
 * 그동안의 dp는 각 인덱스에 해당하는 값을 구한 후,
 * 그 경우의 수 중 가장 큰 값을 찾으면 됐지만
 * 이번에는 다르다!
 *
 * 우선 들어온 카드의 한장 당 가치를 파악한다.
 * (1,000개가 들어온다)
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");

        int arr[] = new int[N+1];
        int d[] = new int[N+1];

        for(int i = 1; i< arr.length;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i<=N;i++){
            for(int j = 1;j<=i;j++){
                // 기존 값과 새로 갱신되는 값을 비교해서 큰 값을 넣어야합니다. -> 최대값을 찾기 위해서
                // dp[i] = dp[n] + dp[i-n] 그리고 이 느낌을 구현한다.
                d[i] = Math.max(d[i],d[i-j] + arr[j]);
            }
        }

        System.out.println(d[N]);
    }

}
