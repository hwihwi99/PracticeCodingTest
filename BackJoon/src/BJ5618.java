import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BJ5618 {

    public static int gcd(int p, int q) {
        if(q==0) {
            return p;
        }
        int temp = p % q;
        p = q;
        q = temp;
        return gcd(p,q);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[] input = new int[n];
        for(int i = 0; i<n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int gcd = 0;

        if(n == 2) {
            gcd = gcd(input[0],input[1]);
        } else if(n==3) {
            gcd = gcd(input[0],input[1]);
            gcd = gcd(input[2], gcd);
        }

        for(int i = 1 ; i<=gcd; i++) {
            if(gcd%i == 0) {
                System.out.println(i);
            }
        }

    }
}
