import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2864 {

    public static int min(String first, String second) {
        int a = Integer.parseInt(first.replace('6','5'));
        int b = Integer.parseInt(second.replace('6','5'));
        return a+b;
    }

    public static int max(String first, String second) {
        int a = Integer.parseInt(first.replace('5','6'));
        int b = Integer.parseInt(second.replace('5','6'));
        return a+b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        String first = st.nextToken();
        String second = st.nextToken();

        int min = min(first,second);
        int max = max(first,second);
        System.out.println(min +" "+ max);
    }
}
