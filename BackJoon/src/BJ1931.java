import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ1931 {

    static class Time implements Comparable<Time>{
        private int start;
        private int end;
        Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public int compareTo(Time t) {
            int cmp = getEnd() - t.getEnd();
            if(cmp == 0) {
                return getStart() - t.getStart();
            }
            return cmp;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Time> arrayList = new ArrayList<>();
        StringTokenizer st;
        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            Time time = new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            arrayList.add(time);
        }
        Collections.sort(arrayList);
        int answer = 0;
        int endTime = 0; // 회의 종료 시점
        for(int i =0; i< arrayList.size(); i++) {
            if(endTime <= arrayList.get(i).getStart()) {
                endTime = arrayList.get(i).getEnd();
                answer++;
            }
        }
        System.out.println(answer);
    }
}
