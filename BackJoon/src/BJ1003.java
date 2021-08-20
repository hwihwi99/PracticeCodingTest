/**
 * 피보나치 함수
 *
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BJ1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int [] dp_0 = new int [41];
        int [] dp_1 = new int [41];

        dp_0[0] = 1;
        dp_1[0] = 0;

        dp_0[1] = 0;
        dp_1[1] = 1;

        for(int i = 2; i<41;i++){
            dp_0[i] = dp_0[i-1]+dp_0[i-2];
            dp_1[i] = dp_1[i-1]+dp_1[i-2];
        }

        for(int i = 0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            System.out.println(dp_0[N]+" "+dp_1[N]);
        }
    }
}
