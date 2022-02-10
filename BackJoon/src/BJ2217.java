import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BJ2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i<N; i++) {
            arrayList.add(Integer.parseInt(br.readLine()));
        }
        int max = 0;
        int totalCount = arrayList.size();
        Collections.sort(arrayList);
        for (int w : arrayList) {
            max = Math.max(max, w * totalCount);
            totalCount --;
        }
        System.out.println(max);
    }
}
