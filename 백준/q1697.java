import java.io.*;
import java.util.*;

public class q1697 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer sb = new StringTokenizer(br.readLine());
        Integer N = Integer.parseInt(sb.nextToken()); //수빈이가 있는 위치
        Integer K = Integer.parseInt(sb.nextToken()); //동생이 있는 위치

        Integer[] list = new Integer[100001];
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> aQueue = new LinkedList<>();
        //list[N] = 1;
        queue.add(N);
        Integer result;
        if(K<N){
            result = N-K;
        }
        result = calculator(queue,aQueue, list, K);
        
        bw.write(result+"\n");


        br.close();
        bw.flush();
        bw.close();
    }

    //목적지 도착시 return
    //start점에서 +1, -1, *2를 너비우선탐색
    //큐에서 대기중이면 1, 다녀간 곳은 2, 처음 온 곳이면 null

    //0일 경우
    static int calculator(Queue<Integer> queue,Queue<Integer> aQueue, Integer[] list, Integer K){
        int count = 0;
        int cCount = -1;
        int temp;
        count = queue.size();
        while(true){
            count--;
            if(count == 0){
                cCount +=1;
                count = queue.size();
            }
            
            if(queue.peek().equals(K)){
                return cCount;
            }

            temp = aQueue.size();
            //이전에서 온 방향이 어디인지에 따라 
            if((temp == 0 || aQueue.peek() != 2) && queue.peek()+1<=100000){
                list[queue.peek()+1] = 1;
                queue.add(queue.peek()+1);
                aQueue.add(1);
            }
            if((temp == 0 || aQueue.peek() != 1)&& queue.peek()-1>=0){
                list[queue.peek()-1] = 1;
                queue.add(queue.peek()-1);
                aQueue.add(2);
            }
            if(queue.peek() != 0 && queue.peek()*2<=100000){
                list[queue.peek()*2] = 1;
                queue.add(queue.peek()*2);
                aQueue.add(3);
            }
            list[queue.peek()] = 2;
            if(temp != 0){
                aQueue.poll();
            }
            queue.poll();
        }
    }
}
