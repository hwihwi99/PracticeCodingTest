import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 해시 맵을 이용
public class BJ17219 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String,String> hashMap = new HashMap<>();

        for(int i = 0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            String site = st.nextToken();
            String password = st.nextToken();
            hashMap.put(site,password);
        }

        for(int i = 0;i<M;i++){
            String get = br.readLine();
            System.out.println(hashMap.get(get));
        }

    }
}
