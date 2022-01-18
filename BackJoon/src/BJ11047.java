import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 문제를 푼 방식
 * 앞서 1,2주차에 풀었던 문제 중 유사한 것들이 있었습니다.
 * 우선 동전의 가치가 큰 것부터 갯수를 줄여나가면 됩니다.
 * 이 때 가장 작은 동전의 가치는 무조건 1이므로 동전이 나눠지지 않을 걱정은 하지 않아도 됩니다.
 *
 * 유사문제가 많았으므로 더 자세한 설명은 하지 않겠습니다.
 *
 * 새로 알게 된 사실
 * 딱히 없습니다.
 * */

public class BJ11047 {
    private static ArrayList<Integer> money = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        for(int i = 0; i<N; i++) {
            money.add(Integer.parseInt(br.readLine()));
        }

        Collections.reverse(money);
        int answer = 0;

        for(int i = 0; i<N; i++) {
            int temp = K / money.get(i);
            K -= temp * money.get(i);
            answer += temp;
            if(K == 0) {
                break;
            }
        }
        System.out.println(answer);
    }
}
