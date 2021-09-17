import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BJ1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0;i<input.length();i++){
            arr.add(input.charAt(i) - '0');
        }
        Collections.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int i = arr.size()-1;i >= 0;i--){
            sb.append(arr.get(i));
        }
        System.out.println(sb);
    }
}
