import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 문제를 푼 방식
 * 값의 최소값을 출력하기 위해서는 시간이 적은 사람부터 일을 처리하게하면 됩니다.
 * 그래서 시간을 arrayList에 저장하고 그것을 오름차순 정렬합니다.
 *
 * 문제의 예시처럼
 * 3,1,4,3,2라면 정렬하여 1,2,3,3,4이고
 * 1
 * 1,2
 * 1,2,3
 * 1,2,3,3
 * 1,2,3,3,4를
 * 모두 더해야합니다.
 *
 * 시점별로 필요한 시간을 구해야하는데
 * 이 때 빠르게 문제에 접근하기 위해서는
 * 전에 있던 시간에 현재 시간을 더한값을 값에 더해주어야합니다.
 *
 * 그래서 변수에 이전시점까지의 값을 저장해두어야합니다.
 *
 * 그 값에 현재 시간을 더해서 답에 더해줍니다.
 *
 * 새로 알게 된 사실
 * 새로 알게 된 점이라기 보다는 DP를 사용하면 더 좋은 풀이가 될 수 있을 것으로 예상합니다.
 * 다음에 DP를 좀 더 공부하고 이 문제를 DP로 바꿔서 풀어보겠습니다.
 *
 * */

public class BJ11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        ArrayList<Integer> inputArray = new ArrayList<>();
        for(int i = 0; i<N; i++) {
            inputArray.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(inputArray);

        int answer = 0;
        int beforeSum = 0;
        for(int i = 0; i<N; i++) {
            beforeSum += inputArray.get(i);
            answer += beforeSum;
        }

        System.out.println(answer);
    }
}
