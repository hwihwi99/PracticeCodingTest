/**
 * 일단 완전 탐색으로 따져보면..
 * 근데 너무 많은 경우의 수가 나오겠지..??
 *
 * 자, 그럼 어떻게 해야되지?? => 가짜문제를 만들어야죠!
 *
 * 가짜문제!
 * i자리 문자열이면 dp[i] = 총 나올 수 있는 경우의 수
 *
 * 그럼... i번째면 .. 기존 내 값에서... i-2 일때에서 2자리 더할 수도 있고
 * i-1 일때에서 1자리 문자열 더할 수도 있지!
 *
 * 조건 1. 0은 글자로 바꿀 수 없다.
 * 조건 2. 숫자는 1~26이 가능하다.
 *
 * */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        int [] arr = new int[len+1];
        int [] dp = new int[len+1];

        for(int i = 0; i<len;i++){
            arr[i+1] = Integer.parseInt(str.substring(i,i+1));
        }

        dp[0] = 1;

        for(int i = 1; i<= len;i++){
            if(arr[i] != 0){
                dp[i] = (dp[i-1] + dp[i]) % 1000000;
            }

            int x = arr[i] + arr[i-1]*10;

            if(10<=x && x <= 26){
                dp[i] = (dp[i-2]+dp[i]) % 1000000;
            }
        }

        System.out.println(dp[len]);





    }
}
