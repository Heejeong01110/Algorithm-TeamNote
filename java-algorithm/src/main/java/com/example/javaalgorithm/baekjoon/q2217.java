import java.io.*;
import java.util.*;

public class q2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Integer N = Integer.parseInt(br.readLine()); //로프의 갯수
        Integer[] loop = new Integer[N];
        for(int i=0;i<N;i++){
            loop[i] = Integer.parseInt(br.readLine());
        }

        Integer sum = 0;
        Integer result = 0;
        Arrays.sort(loop,Collections.reverseOrder());
        for(int i=1;i<=N;i++){
            sum = loop[i-1] * i;
            if(sum>result){
                result = sum;
            }
        }

        bw.write(result+"\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
