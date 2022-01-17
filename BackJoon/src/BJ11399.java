import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        ArrayList<Integer> inputArray = new ArrayList<>();
        for(int i = 0; i<N; i++) {
            inputArray.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(inputArray);

        int answer = 0;
        int beforeSum = 0;
        for(int i = 0; i<N; i++) {
            beforeSum += inputArray.get(i);
            answer += beforeSum;
        }

        System.out.println(answer);
    }
}
