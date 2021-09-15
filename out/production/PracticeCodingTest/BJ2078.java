/**
 *
 * (팩트)
 * 주어진 값 중 왼쪽이 더 크면 부모노드에서 왼쪽으로 이동한 경우 (a+b, b)
 * 오른쪽 값이 더 크다면 부모노드에서 오른쪽으로 이동한 경우 (a, a+b)
 *
 * (방법)
 * 부모 노드의 값은 작은 자식의 값 중 작은 값은 유지되고,
 * 큰쪽의 값은 큰값에서 작은 값을 뺸 값이 된다..
 * 자식이 (5,2) -> (5-2,2)로 (3,2)가 됩니다.
 *
 * 위의 방법을 반복한다.
 *
 * 예외사항)
 *  (2,000,000,000 , 1)의 경우 한쪽으로 너무 치우쳐있으면 타임아웃이 난다.
 *  만약 한쪽으로 k번을 이동하게 된다면 이동한 방향의 반대쪽의 값을 k번 더하게 된다.
 *
 *  그리고 시작점은 반드시 이동한 방향의 반대쪽 값이 더 크게 됩니다..
 *  그래서
 *
 *  왼쪽 값이 크다면 -> 왼쪽으로 이동한 칸 수 = 왼쪽값/오른쪽값
 *  오른쪽 값이 크다면 -> 오른쪽으로 이동한 칸 수 = 오른쪽값/왼쪽값
 *
 *  한 방향으로 이동한 횟수를 구한 다음, 3을 이용해서 부모 노드의 값을 구하고
 *  다시 같은 방향으로 이동한 횟수를 구하는 연산을 반복하면 됩니다.
 *
 * 메모리초과를 해결하기 위해서....
 * 구글링했다..
 * => 아니 어떻게 이렇게 짧게 코드를 쓰고 이런 생각을 하지...진짜 대단하네
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2078 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int numx = Integer.parseInt(st.nextToken());
        int numy = Integer.parseInt(st.nextToken());

        int left = 0, right = 0;
        // 무한 루프를 돌면서
        while(true){

            // 만약 특정 수가 1이라면.. 한쪽방향으로만 움직였을거니깐!

            // 왼쪽값이 1이면 오른쪽으로만 계속 움직였겠지??
            if(numx==1){
                right += numy -1;
                break;
            }

            // 반대로 오른쪽값이 1이면 왼쪽으로만 계속 움직였겠네!
            else if(numy == 1){
                left += numx -1;
                break;
            }


            if(numx > numy){
                left += numx/numy;
                numx = numx % numy;
            }else{
                right += numy/numx;
                numy = numy % numx;
            }
        }
        System.out.println(left+" "+right);
    }
}
