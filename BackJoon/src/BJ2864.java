import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 문제를 푼 방식
 * 5와 6을 바꿔가면서 두 수의 최대값과 최소값을 구하면 됩니다.
 * 이 때, 5를 6으로 바꾸고 6을 가만히 두면 합이 최대
 * 6을 5로 바꾸고 5를 가만히 두면 합이 최소가 될 것이므로
 * 최대를 구할때는 5를 6으로 바꾸고
 * 최소를 구할때는 6을 5로 바꾼 후 계산합니다.
 *
 * 처음에는 입력받는 동시에 문자열을 숫자로 만들고 그 숫자를 자릿수에 맞게 배열로 만든 다음에
 * 배열을 돌면서 5와 6을 바꾸는 연산을 하고 다시 수로 만들어서 합을 구하려고 했습니다.
 * 하지만 이 과정은 for 문을 정말 여러개를 사용해야했고 귀찮았습니다.
 *
 * 그런데 생각해보니까 값이 문자열로 들어오니 이 문자열을 그대로 사용하면 된다고 생각했습니다.
 * 그렇게 문자열로 사용하고 보니 replace 메서드를 사용하여 쉽고 빠르게 답을 구할 수 있었습니다.
 *
 * 새로 알게 된 사실
 * replace함수가 subString을 바꾸는 역할을 한다고 생각했습니다.
 * 즉 replace의 인자값들이 문자열인줄 알았는데 char형이였습니다.
 * 제가 예전에 replace 메서드를 사용하면서 여러 런타임 에러가 발생했었는데 아마 이 부분때문이지 않았을까 합니다.
 * */
public class BJ2864 {

    public static int min(String first, String second) {
        int a = Integer.parseInt(first.replace('6','5'));
        int b = Integer.parseInt(second.replace('6','5'));
        return a+b;
    }

    public static int max(String first, String second) {
        int a = Integer.parseInt(first.replace('5','6'));
        int b = Integer.parseInt(second.replace('5','6'));
        return a+b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        String first = st.nextToken();
        String second = st.nextToken();

        int min = min(first,second);
        int max = max(first,second);
        System.out.println(min +" "+ max);
    }
}
