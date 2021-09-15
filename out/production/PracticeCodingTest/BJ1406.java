import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class BJ1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        // 입력받은 문자열을 링크드리스에 넣기
        String[] str = br.readLine().split("");

        List<String> list = new LinkedList<>();
        for(String s : str){
            list.add(s);
        }

        ListIterator<String> it = list.listIterator();

        //커서가 마지막에 있으니깐 일단 위치를 마지막으로 위치시킨다.
        while(it.hasNext()){
            it.next();
        }

        // 총 수행할 명령어 갯수
        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i<num; i++){

            st = new StringTokenizer(br.readLine()," ");

            switch (st.nextToken()){
                case "L":
                    if(it.hasPrevious()){
                        it.previous();
                    }
                    break;
                case "D":
                    if(it.hasNext()) {
                        it.next();
                    }
                    break;
                case "B":
                    if(it.hasPrevious()){
                        it.previous();
                        it.remove();
                    }
                    break;
                case "P":
                    it.add(st.nextToken());
                    break;
            }
        }
        StringBuilder builder = new StringBuilder();
        for(String ans : list){
            builder.append(ans);
        }
        System.out.println(builder.toString());
    }
}
