import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 문제를 푼 방식
 * 커플석이 없다고 가정했을 때 의자수보다 + 1 만큼의 컵홀더 공간이 있습니다.
 * 그래서 count 초기값을 1로 시작해서 커플석이 있을 때는 1을 하나 더하고 다음 자리는 넘어갑니다.
 * 커플석이 아닌 자리는 그냥 +1을 해줍니다.
 *
 * 이 문제는 인덱스 처리를 효율적으로 하는 방법을 생각해볼 수 있었습니다.
 * 새로 알게 된 사실
 * 딱히 없습니다.
 * */
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
