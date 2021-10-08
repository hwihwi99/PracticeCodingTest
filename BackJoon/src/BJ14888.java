import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14888 {
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;
    static int N;
    static int[] op;
    static int[] numInput;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        numInput = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i<N; i++){
            numInput[i] = Integer.parseInt(st.nextToken());
        }
        op = new int[4];
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i<4; i++){
            op[i] = Integer.parseInt(st.nextToken());
        }
        dfs(numInput[0],1);
        System.out.println(MAX);
        System.out.println(MIN);
    }
    public static void dfs(int num, int index){
        if(index == N){
            MAX = Math.max(MAX,num);
            MIN = Math.min(MIN,num);
        }
        for(int i = 0; i<4; i++){
            if(op[i]>0){
                op[i]--;
                switch (i){
                    case 0:
                        dfs(num + numInput[index],index+1);
                        break;
                    case 1:
                        dfs(num - numInput[index],index+1);
                        break;
                    case 2:
                        dfs(num * numInput[index],index+1);
                        break;
                    case 3:
                        dfs(num / numInput[index],index+1);
                        break;
                }
                op[i]++;
            }
        }
    }
}
