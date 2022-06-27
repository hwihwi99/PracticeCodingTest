import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * POINT1. 입력갯수가 정해져있지 않고 마지막 0으로만 구분되어 BufferedReader를 쓰는데 좀 문제가 있었음.
 * -> 0일때까지 받는걸로 해결하면 됐던 생각보다 간단했던 문제... -> 이걸로 20분은 쓴듯..
 *
 * 사실 소수문제는.....잘 모르겠다...이게 맞는지... 어떨때는 맞고...어떨때는 또 틀리고...
 * */

public class BJ4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arrayList = new ArrayList<>();
        String line;

        while (!(line = br.readLine()).equals("0")) {
            int n = Integer.parseInt(line);
            arrayList.add(n);
        }

        for(int n : arrayList) {
            int subAnswer = 0;

            int count = 0;
            for(int i = n+1; i<=2*n; i++) {
                int j;
                for(j = 2; j*j <= i; j++) {
                    if(i%j == 0)
                        break;
                }
                if((j*j > i) == (i != 1)) {
                    count++;
                }

            }
            System.out.println(count);
//            for(int i = n+1; i <= 2 * n; i++) {
//                int isPrime = i;
//                int maxSqrt = (int) Math.sqrt(isPrime); // 9 1~9 9 3
//
//                int temp = 0;
//                for(int j = 1; j<=maxSqrt; j++) {
//                    if(isPrime % j == 0) {
//                        temp++;
//                    }
//                }
//                if(temp == 1 && isPrime != 1) {
//                    subAnswer += 1;
//                }
//            }
//
//            System.out.println(subAnswer);
        }


    }
}
