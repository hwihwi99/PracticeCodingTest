import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        char[] inputArray = N.toCharArray();

        int answer = 0;

        for(int i = 0; i< inputArray.length; i++) {
            char tempC = inputArray[i];
            int tempNum;
            if(tempC >= 'A' && tempC <= 'Z') {
                tempNum = (tempC - 'A') + 10;
            } else {
                tempNum = (int) tempC - 48;
            }
            answer += (tempNum * (int)Math.pow(B,inputArray.length - 1 - i));
        }
        System.out.println(answer);
    }
}
