import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ2839 {
    public static int delivery(int n){
        ArrayList<Integer> list = new ArrayList<>();
        int answer = 0;
        int num ;
        for(int i = 0; i<=n/3; i++){
            num = n;
            answer = i;
            num = num - 3*i;
            if(num%5==0){
                answer += num/5;
                list.add(answer);
            }else{
                continue;
            }
        }
        if(list.isEmpty()){
            return -1;
        }else {
            Collections.sort(list);
            return list.get(0);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int num = Integer.parseInt(st.nextToken());
        System.out.println(delivery(num));
    }
}
