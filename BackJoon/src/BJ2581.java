import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();
        int sum = 0;
        for(int i = M; i<=N; i++) {

            if(i == 1)
                continue;
            if(i == 2){
                arrayList.add(i);
                sum += i;
            }
            for(int j = 2; j<i;j++) {
                if(i % j == 0) {
                    break;
                }
                if(j == i-1){
                    sum += i;
                    arrayList.add(i);
                }
            }
        }
        if(arrayList.isEmpty())
            System.out.println(-1);
        else {
            System.out.println(sum);
            System.out.println(arrayList.get(0));
        }
    }
}
