import java.util.Arrays;
import java.util.Scanner;

public class BJ1920{

    private static int BinarySearch(int []A, int value){
        int lo = 0;
        int hi = A.length-1;
        while (lo<=hi){
            int mid = (lo + hi) /2;
            if(value < A[mid]){
                hi = mid-1;
            }else if (value>A[mid]){
                lo = mid + 1;
            }else{
                return 1;
            }
        }
        return 0;
    }


    // 이진 탐색을 사용해서 기존에 받아온 배열을 정렬하고
    // 또 다른 입력값을 이용해서 존재 여부를 파악한다.

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int [N];
        for(int i = 0; i<N;i++){
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);
        int M = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<M;i++){
            sb.append(BinarySearch(A,sc.nextInt())).append("\n");
        }
        System.out.println(sb.toString());
    }
}
