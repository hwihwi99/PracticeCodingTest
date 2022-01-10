import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
