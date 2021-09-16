import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

public class BJ1260 {

    public static Queue<Integer> bfs(HashMap<Integer,ArrayList<Integer>> graph, int start){
        Queue<Integer> visited = new LinkedList<>();
        Queue<Integer> needVisit = new LinkedList<>();

        needVisit.offer(start);

        while(!needVisit.isEmpty()){
            int node = needVisit.poll();
            if(!visited.contains(node)){
                visited.offer(node);
                needVisit.addAll(graph.get(node));
            }
        }
        return visited;
    }

    public static Queue<Integer> dfs(HashMap<Integer,ArrayList<Integer>> graph, int start){
        Queue<Integer> visited = new LinkedList<>();
        ArrayList<Integer> needVisit = new ArrayList<>();

        needVisit.add(start);

        while(!needVisit.isEmpty()){
            int node = needVisit.remove(needVisit.size()-1);
            if(!visited.contains(node)){
                visited.offer(node);
                Collections.reverse(graph.get(node));
                needVisit.addAll(graph.get(node));
            }
        }
        return visited;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>(N);

        for(int i = 1;i<=N;i++){
            graph.put(i,new ArrayList<>());
        }

        for(int i = 0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            if(!graph.get(first).contains(second)){
                graph.get(first).add(second);
                graph.get(second).add(first);
            }
        }

        for(int i = 1;i<=N;i++){
            Collections.sort(graph.get(i));
        }

        Queue<Integer> bfsans = new LinkedList<>();
        Queue<Integer> dfsans = new LinkedList<>();

        bfsans = bfs(graph,V);
        dfsans = dfs(graph,V);

        for(int i : dfsans){
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i : bfsans){
            System.out.print(i + " ");
        }
    }
}