import java.io.*;
import java.util.*;

public class BJ1764{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N,M;
    static String [] A,B;

    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        A = new String[N];
        B = new String[M];
        for(int i = 0; i<N;i++){
            A[i] = scan.nextLine();
        }
        for(int i = 0; i<M;i++){
            B[i] = scan.nextLine();
        }
    }

    public static String Search(String key){
        Arrays.sort(B);
        int L = 0;
        int R = B.length-1;
        while(L<=R){
            int mid = (L+R)/2;
            if(B[mid].compareTo(key) > 0){
                R = mid - 1;
            }else if(B[mid].compareTo(key)<0){
                L = mid + 1;
            }
            else{
                return key;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        input();
        ArrayList<String> ans = new ArrayList<>();
        for(int i = 0; i<N;i++){
            if(Search(A[i])!=null)
                ans.add(A[i]);
        }
        Collections.sort(ans);
        System.out.println(ans.size());
        for(int i = 0; i<ans.size();i++){
            System.out.println(ans.get(i));
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}
