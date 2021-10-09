import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1182 {
    static int N,S;
    static int [] input;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        input = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0;i<N;i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0);
        if(S == 0){
            // count합이 0인 경우 공집합으로 처리되므로 하나 뺴고 출룍
            result--;
        }
        System.out.println(result);
    }

    public static void dfs(int index, int sum){
        if(index == N){
            if(sum == S)
                result++;
            return;
        }
        dfs(index+1, sum+input[index]);
        dfs(index+1, sum);
    }
}
