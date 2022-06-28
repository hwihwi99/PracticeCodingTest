import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 올림 [(전체 길이 - 낮동안 올라갈 수 있는 거리) / (낮-밤 == 총 거리)] + 1
 *
 * 예외 : 전체길이 - 낮길이 <= 0 : 한번에 다 오르기 가능
 *
 * 만약 나눠떨어지지 않는다면 무조건 올림
 * */
public class BJ2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int leftV = V - A;

        if(leftV == 0) {
            // 하루만에 다 올라갔다면
            System.out.println(1);
            return;
        }

        int totalClimb = A - B;
        int answer = 1;

        if(leftV % totalClimb == 0) {
            answer += leftV / totalClimb;
        }else{
            answer += leftV/totalClimb + 1;
        }
        System.out.println(answer);

    }
}
