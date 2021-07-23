import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ10816 {
    public static void main(String[] args) throws IOException {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");

        for(int i = 0; i<N;i++){
            int key = Integer.parseInt(st.nextToken());
            if(hashMap.containsKey(key)){
                hashMap.put(key,hashMap.get(key)+1);
            }else{
                hashMap.put(key,1);
            }
        }

        StringBuilder builder = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0;i<M;i++){
            int key = Integer.parseInt(st.nextToken());
            if(hashMap.containsKey(key))
                builder.append(hashMap.get(key)).append(" ");
            else
                builder.append(0).append(" ");
        }
        System.out.println(builder.toString());

    }
}
