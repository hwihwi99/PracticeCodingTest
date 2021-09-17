import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        HashSet<String> hashSet = new HashSet<>();
        for(int i = 0; i<M;i++){
            hashSet.add(br.readLine());
        }
        int ans = 0;
        for(int i = 0;i<N;i++){
            if(hashSet.contains(br.readLine())){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
