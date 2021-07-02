import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2739 {
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        int dan = Integer.parseInt(st.nextToken());

        for(int i = 1; i<=9;i++){
            System.out.println(dan+" * "+i+" = "+dan*i);
        }
    }
}
