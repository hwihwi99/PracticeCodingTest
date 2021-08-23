import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ11650 {

    static class Data implements Comparable<Data> {
        int first;
        int second;
        Data(int first, int second){
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Data o) {
            if(o.first == this.first){
                return this.second - o.second;
            }
            return this.first - o.first;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        ArrayList<Data> datas = new ArrayList<>();
        for(int i = 0; i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            Data newData = new Data(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            datas.add(newData);
        }
        Collections.sort(datas);
        for(Data d : datas){
            System.out.println(d.first+" "+d.second);
        }
    }
}
