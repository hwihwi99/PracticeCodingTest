import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ2609 {

    public static int gbd(int p, int q) {
        if(q == 0)
            return p;
        return gbd(q,p%q);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int gbd = gbd(a,b);
        int lcm = gbd * (a/gbd) * (b/gbd);
        System.out.println(gbd);
        System.out.println(lcm);
    }
}
