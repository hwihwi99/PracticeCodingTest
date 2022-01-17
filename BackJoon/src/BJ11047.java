import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

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
