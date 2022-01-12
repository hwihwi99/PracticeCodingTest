import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 문제를 푼 방식
 * 지난시간에 풀었던 전자레인지(10162), 거스름돈(5585) 문제와 정말 유사했습니다.
 * 다른점이라면 float형으로 계산을 해야했던 점입니다.
 * 하지만 입력받는 수가 센트단위이고 동전의 단위가 달러이므로
 * 단위를 통일시켜 줄 때 동전의 종류를 센트로 변경한다면
 * 까다로운 float 자료형 연산이 아닌 int 자료형 연산이 가능해진다는 점입니다.
 *
 * 그 외의 문제풀이 방법은 1주차때 자세히 설명했으므로 여기서는 생략하도록 하겠습니다.
 *
 * 새로 알게 된 사실
 * 딱히 없습니다.
 * */
public class BJ2720 {

    public static int[] coins = {25,10,5,1};
    public static int[] getChange(int change) {
        int[] result = new int[4];
        for(int i = 0; i<4;i++) {
            result[i] = change / coins[i];
            change %= coins[i];
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int change = Integer.parseInt(st.nextToken());
            int[] answer = getChange(change);
            for(int a : answer) {
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }
}
