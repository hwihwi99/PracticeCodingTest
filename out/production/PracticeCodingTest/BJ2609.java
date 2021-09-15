import java.util.Scanner;

public class BJ2609 {

    public static int gcd(int p, int q){
        if(q == 0)
            return p;
        return gcd(q,p%q);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int gcd = a>b?gcd(a,b):gcd(b,a);
        int lcm = a * (b/gcd);

        System.out.println(gcd);
        System.out.println(lcm);
    }
}
