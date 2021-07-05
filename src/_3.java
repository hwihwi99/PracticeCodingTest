public class _3 {
    public static int solution(String s, String t){
        int result = -1;
        String tmp;
        do{
            tmp = s;
            s= s.replace(t,"");
            result++;
        }while(!tmp.equals(s));
        return result;
    }
    public static void main(String [] args){
        System.out.println(solution("aabcbcd","abc"));
    }
}
