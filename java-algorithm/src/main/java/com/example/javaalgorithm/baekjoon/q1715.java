import java.io.*;
import java.util.*;

public class q1715 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        //초기화
        Integer N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            queue.add(Integer.parseInt(br.readLine()));
        }


        if(queue.size() == 1){
            bw.write("0\n");
            bw.flush();
            br.close();
            bw.close();
            return;
        }

        Integer result = 0;
        
        Integer a = 0;
        while(queue.size() >= 2){
            
            a = cardMerge(queue.poll(), queue.poll());
            queue.add(a);
            result +=a;
        }
        bw.write(result+"\n");

        bw.flush();
        br.close();
        bw.close();
    }

    static Integer cardMerge(Integer a, Integer b){
        return a+b;
    }
}
