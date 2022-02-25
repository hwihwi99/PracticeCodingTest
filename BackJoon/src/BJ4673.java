public class BJ4673 {
    public static void main(String[] args) {
        boolean[] isNonSelfNum = new boolean[10001];

        for(int i = 1; i <= 10000; i++) {
            int temp = i;
            int tempI = i;
            while(tempI != 0) {
                temp += (tempI % 10);
                tempI /= 10;
            }
            if(temp < 10001)
                isNonSelfNum[temp] = true;
        }

        for(int i = 1; i< 10001; i++) {
            if(!isNonSelfNum[i])
                System.out.println(i);
        }
    }
}
