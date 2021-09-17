import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1764{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        HashSet<String> hashSet = new HashSet<>();
        for(int i = 0; i<M;i++){
            String name = br.readLine();
            hashSet.add(name);
        }
        ArrayList<String> ans = new ArrayList<>();
        for(int i = 0; i<N;i++){
            String name = br.readLine();
            if(hashSet.contains(name)){
                ans.add(name);
            }
        }
        System.out.println(ans.size());
        Collections.sort(ans);
        for(String name : ans){
            System.out.println(name);
        }
    }
}