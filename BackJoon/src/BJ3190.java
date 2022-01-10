import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ3190 {
    static int N;
    static int K;
    static int[][] map; // 사과가 있는 곳은 1로 없으면 0으로 처리할 것
    static int L;

    static Map<Integer, String> location;

    static int index = 0;
    static int[] dx = {0,1,0,-1}; // 세로로 움직이기
    static int[] dy = {1,0,-1,0}; // 가로로 움직이기기
    static int count;

    static List<int[]> snake; // 뱀의 몸통 위치(x,y)

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        K = Integer.parseInt(bufferedReader.readLine());
        map = new int[N+1][N+1];
        StringTokenizer st;
        for(int i = 0; i <K; i++) {
            st = new StringTokenizer(bufferedReader.readLine()," ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r-1][c-1] = 1;
        }
        L = Integer.parseInt(bufferedReader.readLine());
        location = new HashMap<>();
        for(int i = 0; i<L; i++) {
            st = new StringTokenizer(bufferedReader.readLine()," ");
            int time = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();
            location.put(time,direction);
        }
        count = 0;
        snake = new ArrayList<>();
        snake.add(new int[]{1,1});

        int nextX, nextY;
        int currentX = 1;
        int currentY = 1;

        while (true) {
            count++;
            nextX = currentX + dx[index];
            nextY = currentY + dy[index];

            // 움직임이 종료되는지 확인하기
            if (isFinish(nextX, nextY)) {
                break;
            }

            // 사과가 있으면 그 자리를 0으로 바꾸고 머리를 늘린 후 꼬리는 가만히
            if(map[nextX][nextY] == 1) {
                map[nextX][nextY] = 0;
                snake.add(new int[]{nextX, nextY});
            }
            else {
                snake.add(new int[] {nextX, nextY});
                snake.remove(0);
            }
            currentX = nextX;
            currentY = nextY;

            if(location.containsKey(count)) {
                if(location.get(count).equals("D")) {
                    index ++;
                    if(index == 4) {
                        index = 0;
                    }
                }

                if(location.get(count).equals("L")) {
                    index --;
                    if(index == -1) {
                        index = 3;
                    }
                }
            }
        }
        System.out.println(count);
    }

    static boolean isFinish(int nextX, int nextY) {
        if(nextX < 1 || nextY < 1 || nextX >= N+1 || nextY >= N+1) {
            return true;
        }
        for(int i = 0; i<snake.size(); i++) {
            if(nextX == snake.get(i)[0] && nextY == snake.get(i)[1]) {
                return true;
            }
        }
        return false;
    }
}
