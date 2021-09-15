/**
 * 무한 이진 트리
 * 일단 edge 클래스를 만들어서 x,y좌표와
 * 이 좌표가 왼쪽으로, 혹은 오른쪽으로 몇 번 갔는지 확인하는 변수를 만든다.
 *
 * 루트는 1 1 0 0 으로 초기화를 해둔다.
 *
 * 그리고 bfs 방식을 이용해서
 * needvisit : 루트를 넣고
 * needvisit이 끝날 때 까지 반복한다 => 하지만 이것은 끝나지 않을 것이다.
 *
 * needvisit에서 하나씩 꺼내면서 값 비교
 *
 * 같다면 현재 상태의 왼쪽, 오른쪽 값 출력
 * 다르면 자식을 만들어서 needvisit 큐에 넣기
 *
 * 메모리 초과가 뜬다..
 * 아마도 자식이 2^n승으로 많아지는데 계속해서 그 값을 넣으려고하다보니
 * needVisit 메모리에 한계가 생겼을 것 같다.
 */

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2078_MemoryOverflow {

    // 각 점에 대한 정보를 담을 클래스
    static class Edge{
        int x;
        int y;
        int CountLeft;
        int CountRight;

        public Edge(int x, int y, int countLeft, int countRight) {
            this.x = x;
            this.y = y;
            CountLeft = countLeft;
            CountRight = countRight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int inputx = Integer.parseInt(st.nextToken());
        int inputy = Integer.parseInt(st.nextToken());

        // 루트 생성자
        Edge root = new Edge(1,1,0,0);

        Queue<Edge> needVisit = new LinkedList<>();
        needVisit.add(root);

        while (!needVisit.isEmpty()) {
            Edge temp = needVisit.poll();

            // 만약 해당하는 값을 찾았다면 왼쪽 오른쪽 값 출력하고 함수 끝내기기
            if (temp.x == inputx && temp.y == inputy) {
                System.out.println(temp.CountLeft + " " + temp.CountRight);
                return;
            }

            Edge leftChild = new Edge(temp.x + temp.y, temp.y, temp.CountLeft + 1, temp.CountRight);
            Edge rightChild = new Edge(temp.x, temp.x + temp.y, temp.CountLeft, temp.CountRight + 1);

            needVisit.add(leftChild);
            needVisit.add(rightChild);
        }
    }
}
