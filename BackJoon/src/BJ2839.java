import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
/**
 * 처음 생각
 * -> 5로 일단 다 나누고 3으로 나눠떨어지면 성공
 * 만약 3으로 나눠떨어지지 않는다면 수 자체가 3으로 나눠떨어지는지 확인
 *
 * 문제점
 * -> 11의 경우 5*2로 10을 차지하고 1이 남아서 -1을 출력하게 된다.
 * 하지만 5 3 3 으로 3의 값이 나와야한다.
 *
 * 수정
 * -> 5를 하나씩 빼고 남은 수가 3으로 나눠떨어지는지 확인하고
 * 나눠떨어지면 최소값이니까 minAnswer를 갱신
 *
 * 계속해서 진행하면서 5로 나눌 수 있는 최대 몫까지 진행
 *
 * --> 결과 : 성공
 * 근데 뭔가 DP나 DFS같은 방법으로 풀 수 있을 것만 같다...
 * 아닌가... 숫자가 작아서 이게 더 효율적이려나
 * */
public class BJ2839 {

    public static int delivery(int N) {
        int minAnwer = Integer.MAX_VALUE;
        int temp = N;

        for(int i = 0; i<=N/5; i++) {
            int tempAnswer = i;
            temp = temp - 5 * i;
            if(temp % 3 == 0) {
                tempAnswer += temp/3;
                if(minAnwer > tempAnswer) {
                    minAnwer = tempAnswer;
                }
            }
            temp = N;
        }
        if(minAnwer == Integer.MAX_VALUE){
            return -1;
        }
        return minAnwer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = delivery(N);
        System.out.println(answer);
    }
}
