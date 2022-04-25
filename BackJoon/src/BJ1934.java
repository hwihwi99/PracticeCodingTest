import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1934 {

    public static int gdb(int a, int b){
        if(b == 0)
            return a;
        return gdb(b,a%b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int gbd = gdb(a,b);
            System.out.println(gbd*(a/gbd)*(b/gbd));
        }
    }
}
