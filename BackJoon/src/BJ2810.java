import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String seatInfo = br.readLine();
        char[] seats = seatInfo.toCharArray();

        int seatNum = 1;
        for(int i = 0; i<seats.length; i++) {
            if(seats[i] == 'L'){
                i++;
            }
            seatNum++;
        }
        int answer = seatNum < N ? seatNum : N;
        System.out.println(answer);
    }
}
