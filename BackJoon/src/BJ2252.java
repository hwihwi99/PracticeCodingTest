import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2252 {

    static ArrayList<Integer> [] graph ;
    static int [] indegree;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int Vertex = Integer.parseInt(st.nextToken());
        int Edge = Integer.parseInt(st.nextToken());

        graph = new ArrayList[Vertex+1];
        indegree = new int [Vertex+1];

        for(int i = 1; i<=Vertex;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0;i<Edge;i++){
            st = new StringTokenizer(br.readLine()," ");
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            graph[first].add(second);
            indegree[second] ++;
        }

        for(int i = 1;i<indegree.length;i++){
            if(indegree[i] == 0)
                queue.add(i);
        }

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()){
            int temp = queue.poll();
            sb.append(temp).append(' ');
            for(int ver : graph[temp]){
                indegree[ver] --;
                if(indegree[ver] == 0)
                    queue.add(ver);
            }
        }

        System.out.println(sb);
    }

}
