import java.io.*;
import java.util.StringTokenizer;

public class q1783 {
    static long N;
    static long M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long result = 0;
        N = Long.parseLong(st.nextToken()); 
        M = Long.parseLong(st.nextToken());

        if (N == 1) {
            result = 1;
        } else if (N == 2) {
            result = Math.min(4, (M + 1) / 2);
        }else if(M<7){
            result =  Math.min(4, M);
        } else{
            result = M - 2;
        }
        
        



        bw.write(result + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

}
