import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10250 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int floor, roomNum;
            if (N % H == 0) {
                roomNum = N / H;
                floor = H;
            }else{
                roomNum = N / H + 1;
                floor = N % H;
            }
            int answer = floor * 100 + roomNum;
            System.out.println(answer);
        }
    }
}
