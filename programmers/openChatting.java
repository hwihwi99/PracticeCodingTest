import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class openChatting {

    private static StringTokenizer st;
    private static final String ENTERMESSAGE = "님이 들어왔습니다.";
    private static final String LEAVEMESSAGE = "님이 나갔습니다.";

    public static String[] solution(String[] record) {

        ArrayList<String> answer = new ArrayList<>(); // 정답을 넣을 공간

        String order;
        String userId;
        String nickname;

        HashMap<String,String> user = new HashMap<>(); // 사용자 정보를 담을 공간
        ArrayList<String> tempList = new ArrayList<>(); // 입장, 퇴장 활동을 저장

        for(String s : record) {
            st = new StringTokenizer(s," ");
            order = st.nextToken();
            userId = st.nextToken();

            if(!order.equals("Change")) {
                tempList.add(order);
                tempList.add(userId);
            }

            if(order.equals("Leave")) {
                continue;
            }

            nickname = st.nextToken();
            user.put(userId,nickname);
        }

        for(int i = 0; i<tempList.size(); i+=2) {
            if(tempList.get(i).equals("Enter")) {
                answer.add(user.get(tempList.get(i+1))+ ENTERMESSAGE);
            }else if(tempList.get(i).equals("Leave")) {
                answer.add(user.get(tempList.get(i+1)) + LEAVEMESSAGE);
            }
        }

        String[] result = new String[answer.size()];
        for(int i = 0; i<answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        String[] answer = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        solution(answer);
    }
}
