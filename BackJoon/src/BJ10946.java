import java.util.Random;

//랜덤한 수와 같으면 만점을 받는다.. 사실 만점은 불가능해보이고
//난이도 측정 불가 문제라는데 왜인지 알겠다ㅋㅋㅋ이상하네
public class BJ10946 {
    public static void main(String []args){
        Random random = new Random();
        int a = random.nextInt(2147483647);
        System.out.println(a);
    }
}
