import java.util.Scanner;

public class BJ1110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int temp = N;
        int answer = 0;

        while (true){
            answer++;
            int first = temp / 10;
            int second = temp % 10;
            int result = (first+second) % 10;

            temp = second*10 + result;
            if(temp == N){
                break;
            }
        }
        System.out.println(answer);
    }
}
