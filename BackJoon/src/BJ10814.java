import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ10814 {
    static class Data implements Comparable<Data>{
        int age;
        String name;
        Data(int age, String name){
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Data o) {

            return this.age - o.age;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Data> datas = new ArrayList<>();

        StringTokenizer st;
        for(int i = 0; i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            Data d = new Data(Integer.parseInt(st.nextToken()), st.nextToken());
            datas.add(d);
        }
        Collections.sort(datas);

        for(Data d : datas){
            System.out.println(d.age+" "+d.name);
        }
    }
}
