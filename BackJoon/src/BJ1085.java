import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int diffx = Math.abs(x-w) > x ? x : Math.abs(x-w);
        int diffy = Math.abs(y-h) > y ? y : Math.abs(y-h);

        int ans = diffx > diffy ? diffy : diffx;
        System.out.println(ans);
    }
}
