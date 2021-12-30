import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14503 {
    private static int N, M;

    private static int[][] roomArray;
    private static boolean[][] visited;

    private static int[] dr = {-1,0,1,0};
    private static int[] dc = {0,1,0,-1};

    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        roomArray = new int[N][M];
        visited = new boolean[N][M];

        st = new StringTokenizer(br.readLine()," ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken()); // 현재 바라보고 있는 방향

        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; i<M; j++) {
                roomArray[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        count = 0; // 청소할 방 갯수
        cleanRoom(r,c,d);
        System.out.println(count);
    }

    public static void cleanRoom(int r, int c, int d) {
        boolean nonBlock = false; // 왼쪽부터해서 사방이 막혔는지 안막혔는지 체크

        if(!visited[r][c]) {
            // 첫 시작하는 부분이 0이면 청소
            visited[r][c] = true;
            count++;
        }

        for(int i = 0; i<4; i++) {
            d = dir_rotation(d);
            int tempr = r + dr[d];
            int tempc = c + dc[d];

            // 만약 청소할 부분을 찾았다면 탐색을 멈추고 그 부분을 청소하자.
            if(roomArray[tempr][tempc] == 0 && !visited[tempr][tempc]) {
                cleanRoom(tempr,tempc,d);
                nonBlock = true;
                break;
            }
        }

        if(nonBlock == false) {
            // 다 돌고나면 어차피 d는 원상복구(360도 돌았기 때문에)

            // 근데 막히면 후진하라고 했으니까 후진하고
            int tempr = r - dr[d];
            int tempc = c - dc[d];

            // 후진한 곳이 0이라면 청소하자.
            if(roomArray[tempr][tempc] == 0) {
                cleanRoom(tempr,tempc,d);
            }
        }
    }

    public static int dir_rotation(int d) {
        if(d == 0) { // 북쪽기준 왼쪽 == 서쪽
            return 3;
        }else if(d == 1) { // 동쪽기준 왼쪽 == 북쪽
            return 0;
        }else if(d == 2) { // 남쪽기준 왼쪽 == 동쪽
            return 1;
        }else { // 서쪽기준 왼쪽 == 남쪽
            return 2;
        }
    }
}
