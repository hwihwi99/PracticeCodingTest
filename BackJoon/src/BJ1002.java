import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            double dis = Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2));

            if(Math.abs(r1-r2)<dis && dis < r1+r2) {
                System.out.println("2");
            } else if (dis == 0 && r1 == r2) {
                System.out.println("-1");
            } else if (dis == Math.abs(r1-r2) || r1 + r2 == dis) {
                System.out.println("1");
            } else if (r1 + r2 < dis || Math.abs(r2-r1) > dis || dis == 0) {
                System.out.println("0");
            }
        }
    }
}
