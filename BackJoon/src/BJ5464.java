import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ5464 {
    public static void main(String[] args) throws IOException {
        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int space = Integer.parseInt(st.nextToken());
        int weight = Integer.parseInt(st.nextToken());

        int [] parking = new int[space];
        for(int i = 0; i<parking.length;i++){
            parking[i] = Integer.parseInt(br.readLine());
        }

        int [] carWeight = new int[weight];
        for(int i = 0; i<carWeight.length;i++){
            carWeight[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i<2*weight;i++){

        }

        System.out.println(answer);
    }
}
