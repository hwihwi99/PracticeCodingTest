import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BJ2108 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 총 입력받을 갯수
        ArrayList<Integer> arr = new ArrayList<>();

        int sum = 0; // 들어오는 수의 총합을 구하기 위한 변수
        for(int i = 0; i<N;i++){
            int inputNum = Integer.parseInt(br.readLine());
            sum += inputNum;
            arr.add(inputNum);
        }

        // 평균
        int avg = (int)Math.round((double)sum / N);

        System.out.println(avg);

        // 중앙값
        Collections.sort(arr);
        System.out.println(arr.get(N/2));

        ///최빈값....
        int mode = 4001;//최빈값
        int mode_max = 0;
        boolean flag = false;

        for(int i = 0; i<N;i++){
            int jump = 0;
            int count = 1;
            int value = arr.get(i);

            for(int j = i+1;j<N;j++){
                if(value != arr.get(j))
                    break;
                count++;
                jump++;
            }

            if(mode_max < count){
                mode_max = count;
                mode = value;
                flag = true;
            }
            else if(count == mode_max && flag==true){
                mode = value;
                flag = false;
            }
            i+= jump;
        }
        System.out.println(mode);
        // 범위 : 최대값 - 최솟값
        int range = arr.get(arr.size()-1) - arr.get(0);
        System.out.println(range);
    }
}
