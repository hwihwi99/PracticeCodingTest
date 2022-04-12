import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ22864 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int answer = 0;
        int time = 0;
        int pirodo = 0;
        int temp = 0;
        while (time<24) {
            time++;
            temp = pirodo + A;
            if(temp <= M) {
                pirodo = temp;
                answer += B;
            } else {
                temp = pirodo - C;
                if(temp < 0) {
                    temp = 0;
                }
                pirodo = temp;
            }
        }

        System.out.println(answer);

    }
}
