import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        for(int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int index = 0;
        int max = arr[0];

        for(int i = 1; i<9; i++) {
            int temp = arr[i];
            if(max < temp) {
                index = i;
                max = temp;
            }
        }
        System.out.println(max);
        System.out.println(index+1);
    }
}
