import java.util.Arrays;
import java.util.Collections;

public class _1 {
    public static int solution(int[]prices, int[]discounts){
        Integer [] pri = Arrays.stream(prices).boxed().toArray(Integer[]::new);
        Integer [] dis = Arrays.stream(discounts).boxed().toArray(Integer[]::new);
        Arrays.sort(pri, Collections.reverseOrder());
        Arrays.sort(dis, Collections.reverseOrder());

        int answer = 0;
        if(dis.length> pri.length){
            for(int i = 0;i< pri.length;i++){
                int money = pri[i]*(100-dis[i])/100;
                answer += money;
            }
        }else {
            for(int i = 0;i<dis.length;i++){
                int money = pri[i]*(100-dis[i])/100;
                answer += money;
            }
            for(int i = dis.length;i< pri.length;i++){
                answer += pri[i];
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int [] pri = {13000,88000,10000};
        int [] dis = {30,20};
        System.out.println(solution(pri,dis));
    }
}
