import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ5464 {
    public static void main(String[] args) throws IOException {
        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int parkingSpace = Integer.parseInt(st.nextToken());
        int cars = Integer.parseInt(st.nextToken());

        // 공간마다 단위 비용
        int [] parkCost = new int[parkingSpace];
        for(int i = 0; i<parkingSpace;i++){
            parkCost[i] = Integer.parseInt(br.readLine());
        }

        // 각 자동차마다의 비용
        int [] carWeight = new int [cars];
        for(int i = 0; i<cars;i++){
            carWeight[i] = Integer.parseInt(br.readLine());
        }

        // 주차 현황 -> 비어있으면 0이고 아니면 그 차의 번호가 들어와있다.
        int [] parking = new int [parkingSpace];
        for(int i = 0; i<parkingSpace;i++){
            parking[i] = 0;
        }

        // 모든 입력값 다 큐에 받기기
        Queue<Integer> inputOutputCar = new LinkedList<>();
        for(int i = 0; i<2*cars;i++){
            inputOutputCar.offer(Integer.parseInt(br.readLine()));
        }

        // 대기 큐
        Queue <Integer> waiting = new LinkedList<>();

        // 현재 차가 주차되어 있는 수
        int cnt = 0;

        //들어온 차와 나가는 차에 대한 모든 정보가 담긴 큐가 비어있을 때 까지!!
        while(!inputOutputCar.isEmpty()){

            //값이 양수라면 == 차가 들어온다면
            if(inputOutputCar.peek()>0){

                //주차 빈공간이 있으면 -> 바로 주차 후 요금 계산
                if(cnt < parkingSpace){
                    for(int i = 0;i<parking.length;i++){
                        if(parking[i] == 0){
                            parking[i] = inputOutputCar.poll();
                            answer += carWeight[parking[i]-1] * parkCost[i];
                            cnt++;
                            break;
                        }
                    }
                }

                // 주차 빈공간이 없으면 -> 대기
                else{
                    waiting.offer(inputOutputCar.poll());
                }

            }

            //값이 음수라면 == 차가 나간다면
            else if (inputOutputCar.peek()<0){

                // parking 되어 있는 찾아서 0으로 만들자 (0은 비어있는 공간)
                int num = inputOutputCar.poll();
                for(int i = 0;i<parking.length;i++){
                    if(parking[i] == num*(-1)){
                        parking[i] = 0;
                        break;
                    }
                }
                cnt--;

                //만약 대기하고 있던 차량이 있다면 빈자리에 넣어주기!
                if(!waiting.isEmpty()){
                    for(int i = 0;i<parking.length;i++){
                        if(parking[i] == 0){
                            parking[i] = waiting.poll();
                            answer += carWeight[parking[i]-1] * parkCost[i];
                            cnt++;
                            break;
                        }
                    }
                }


            }


        }

        System.out.println(answer);
    }
}
