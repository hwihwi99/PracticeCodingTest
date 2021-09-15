import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ1406_TimeOver {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        // 입력받은 문자열을 링크드리스에 넣기
        String str = br.readLine();
        StringBuilder answer = new StringBuilder();
        answer.append(str);

        //현재 커서가 가르키고 있는 위치
        int cursor = answer.length();

        // 총 수행할 명령어 갯수
        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i<num; i++){

            st = new StringTokenizer(br.readLine()," ");

            switch (st.nextToken()){
                case "L":
                    if(cursor != 0){
                        cursor--;
                    }
                    break;
                case "D":
                    if(cursor != answer.length()) {
                        cursor++;
                    }
                    break;
                case "B":
                    if(cursor != 0){
                        answer.delete(cursor-1,cursor);
                        cursor--;
                    }
                    break;
                case "P":
                    answer.insert(cursor,st.nextToken().charAt(0));
                    cursor++;
                    break;
            }
        }
        System.out.println(answer.toString());
    }
}
