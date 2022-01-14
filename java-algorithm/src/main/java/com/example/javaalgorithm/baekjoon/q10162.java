import java.io.*;

public class q10162 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer targetSec = Integer.parseInt(br.readLine());
        int[] buttonSec = {300, 60, 10};
        int[] result = new int[3];

        if(targetSec%buttonSec[2]>0){
            bw.write("-1\n");
            br.close();
            bw.flush();
            bw.close();
            return;
        }
        
        result[2] = targetSec/buttonSec[2];

        if(result[2]/6 >0){
            result[1] = result[2]/6;
            result[2] -= result[1]*6;

            if(result[1]/5>0){
                result[0] = result[1]/5;
                result[1] -= result[0]*5;
            }
        }
        
        for(int i=0;i<result.length;i++){
            bw.write(result[i]+" ");
        }
        bw.write("\n");


        br.close();
        bw.flush();
        bw.close();
    }
}
