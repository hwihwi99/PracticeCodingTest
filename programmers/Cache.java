import java.util.*;
/**
 * 문자열을 모두 소문자로 바꿔준다. (대소문자 구분 안해준다고 했으므로)
 *
 * 처음에는 그냥 포함되어있으면 그걸로 끝냈었음 -> 이러면 65% 정답
 *
 * 이게 포함되어있으면 그래도 가장 최근에 사용할 거니까 가장 최근으로 바꿔줘야되넹
 * 그래서 remove하고 다시 offer하니깐 90점
 *
 * 7번, 17번 2개가 틀린것으로 나옴
 * 이건 크기가 0인경우때문임
 * 크기가 0이라도 for문의 두번째 if문 때문에 큐에 한번 들어가게되고
 * 그러면 다음번에 같은것이 들어오면 이미 있는것으로 파악하고 넘기기 때문에
 *
 * 이번 문제는 구현 자체는 금방했는데 이런저런 예외를 잘 고려해주지 못한것 같다.
 * 다음번에는 예외도 잘 고려해주어야겠다.
 * */
public class Cache {

    public static int solution(int cacheSize, String[] cities) {
        Queue<String> queue = new LinkedList<>();
        int answer = 0;

        if(cacheSize == 0) {
            answer = 5 * cities.length;
            return answer;
        }

        for(String s : cities) {
            s = s.toLowerCase();

            if(queue.contains(s)) {
                queue.remove(s);
                queue.offer(s);
                answer += 1;
                continue;
            }

            if(queue.size() >= cacheSize) {
                queue.poll();
                queue.offer(s);
            }else {
                queue.offer(s);
            }
            answer += 5;
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] cities = {"LA", "LA"};
        System.out.println(solution(0,cities));
    }

}
