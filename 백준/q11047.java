import java.io.*;
import java.util.Arrays;

public class q11047 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Integer N; //동전의 종류
        Integer K; //합
        String[] a = new String[2];
        a =  br.readLine().split(" ");
        N = Integer.parseInt(a[0]);
        K = Integer.parseInt(a[1]);

        Integer[] value = new Integer[N];
        for(int i=0;i<N;i++){
            value[i] = Integer.parseInt(br.readLine());
        }


        Integer result = 0; //동전 합 저장
        Integer count= N-1; //list의 뒤에서부터 동전을 더해가기 위한 인덱스
        Integer coin = 0;
        for(int i=count;i>=0;i--){
            if(value[i] <K){
                count = i;
                break;
            }
        }
        //System.out.print("count : "+count+"\n");


        while(true){
            if(result - K == 0){
                break;
            }
            
            if(K - result>=value[count]){
                result += value[count];
                coin++;
            }else{
                count--;
                
            }   
        }

        bw.write(coin+"\n");


        br.close();
        bw.flush();
        bw.close();
    }
}


