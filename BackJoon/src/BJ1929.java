import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 최근에 풀었던 백준 4948번이랑 매우 유사했음
 * 그런데 처음에는 1,2를 고려하지않고 그냥 했다가 90%에서 틀렸습니다로 바뀜.
 * 생각해보니 1과 2는 좀 신경을 써줘야해서 main에서 처리해줬더니 바로 답이 되었다.
 *
 * 소수 문제는 항상 쉬운데 사소한거에서 실수를 한다. 항상 예외를 고려하자.
 * */
public class BJ1929 {
    private static boolean isPrime(int num) {
        int sqrt = (int) Math.sqrt(num);
        for(int j = 2; j<=sqrt; j++) {
            if(num%j == 0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for(int i = M; i<=N; i++) {
            if(i == 1) {
                continue;
            }
            if(isPrime(i) || i == 2){
                System.out.println(i);
            }
        }
    }
}
