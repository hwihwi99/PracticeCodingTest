import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;

        for(int i = 0; i<num; i++) {
            int N = Integer.parseInt(st.nextToken());
            if(N == 1)
                continue;
            for(int j = 2; j<N;j++) {
                if(N % j == 0)
                    break;
                if(j == N-1)
                    count++;
            }
            if(N == 2)
                count++;
        }
        System.out.println(count);
    }
}
