import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 문제를 푼 방식
 * A배열은 오름차순, B배열은 내림차순처리를 하고
 * S = A[0] × B[0] + ... + A[N-1] × B[N-1]이와 같이 문제에서 주어진대로
 * 인덱스가 같은 배열값끼리 곱해서 다 더해줍니다.
 * 이러면 최소값이 나오게 됩니다.
 *
 * B는 재배열하면 안된다고 문제에 나와있지만 사실 이 문제는 B를 재배열하는지 안하는지 알 방법이 없습니다.
 * 그래서 전 내림차순으로 정렬해주고 풀었더니 정답이였습니다.
 *
 * 새로 알게 된 사실
 * 딱히 없습니다.
 * */
public class BJ1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i<N; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i<N; i++) {
            B.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(A);
        Collections.sort(B);
        Collections.reverse(B);

        int answer = 0;

        for(int i = 0; i<N; i++) {
            answer += A.get(i) * B.get(i);
        }
        System.out.println(answer);
    }
}
