public class Weekly9 {

    boolean [][] edges;
    boolean [] vistied;
    int N;
    public int solution(int n, int[][] wires) {
        N = n;
        edges = new boolean[n][n];
        int length = wires.length;
        int answer = Integer.MAX_VALUE;

        // 서로 연결이 되어 있는 노드들은 true로 만들어준다.
        for(int i = 0; i<length;i++){
            int firstNode = wires[i][0];
            int secondNode = wires[i][1];
            edges[firstNode][secondNode] = true;
            edges[secondNode][firstNode] = true;
        }

        // 하나하나 간선을 끊어가면서 각각의 연결되어 있는 노드들의 수를 카운트합니다.
        for(int i=0;i<length;i++){
            vistied = new boolean[n];
            int firstNode = wires[i][0];
            int secondNode = wires[i][1];
            edges[firstNode][secondNode] = false;
            edges[secondNode][firstNode] = false;

            int firstPart = dfs(firstNode,0);
            int secondPart = dfs(secondNode,0);
            answer = Math.min(answer,Math.abs(firstPart-secondPart));

            edges[firstNode][secondNode] = true;
            edges[secondNode][firstNode] = true;
        }
        return answer;
    }
    public int dfs(int startNode, int cnt){
        if(vistied[startNode]){
            return 0;
        }
        vistied[startNode] = true;
        int sum = 1;
        for(int i = 0; i<N;i++){
            if(!edges[startNode][i]){
                continue;
            }
            sum += dfs(i,cnt+1);
        }
        vistied[startNode] = false;
        return sum;
    }
}
