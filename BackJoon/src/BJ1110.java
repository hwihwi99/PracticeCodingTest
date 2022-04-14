import java.util.Scanner;

public class BJ1110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int answer = 0;
        int temp = N;
        while (true) {

            int first = temp / 10;
            int second = temp % 10;
            int sum = first + second;

            temp = 10 * second + (sum%10);
            answer ++;
            if(N == temp) {
                break;
            }
        }
        System.out.println(answer);
    }
}
