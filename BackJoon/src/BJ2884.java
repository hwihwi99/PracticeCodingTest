import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2884 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int hour = Integer.parseInt(st.nextToken());
        int min =  Integer.parseInt(st.nextToken());

        if(min>=45){
            min -= 45;
            System.out.println(hour+" "+ min);
        }else if (min<45){
            int left = 45 - min;
            min = 60 - left;
            if(hour == 0)
                hour = 23;
            else
                hour -=1;

            System.out.println(hour+" "+ min);
        }
    }
}
