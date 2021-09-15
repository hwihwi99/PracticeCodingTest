/*
* 동적 계획법을 이용한 문제 풀이
* 1. 계단은 한번에 1칸 혹은 2칸씩 오를 수 있다.
* 2. 연속한 세 계단은 밟을 수 없다.(시작점 제외)
* 3. 마지막 계단은 꼭 밟아야한다.
*
* 현재 밟고 있는 계단에서 생각해 보자.
* 1. 바로 전 계단을 밟은 경우 => dp[n-3] + n-1번째 계단 + n번째 계단
* 2. 바로 전 계단을 밟지 않은 경우 => dq[n-2] + n번쨰 계단
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalStep = Integer.parseInt(br.readLine());
        int [] steps = new int[totalStep+1];
        for(int i = 1;i<=totalStep;i++){
            steps[i] = Integer.parseInt(br.readLine());
        }
        int [] dp = new int[totalStep+1];
        dp[1] = steps[1];
        if(totalStep>=2){
            dp[2] = steps[1]+steps[2];
        }
        for(int i = 3; i<=totalStep;i++){
            dp[i] = Math.max(dp[i-2]+steps[i],dp[i-3]+steps[i-1]+steps[i]);
        }
        System.out.println(dp[totalStep]);
    }
}
