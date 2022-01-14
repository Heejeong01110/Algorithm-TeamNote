import java.io.*;
import java.util.*;

public class q2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<Integer,Integer> numh = new HashMap<>();
        int num[] = new int[9];
        
        for (int i = 0; i < 9; i++) {
            num[i] = Integer.parseInt(br.readLine());
            //numh.put(i,Integer.parseInt(br.readLine()));
        }

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if(numSum(num,i,j)==100){
                    num[i] = 0;
                    num[j] = 0;
                    break;
                }
            }
        }

        Arrays.sort(num);
        for (int i = 0; i < 9; i++) {
            if(i>1){
                bw.write(num[i] + "\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static int numSum(int num[],int i,int j) {
        int result = 0;
        for (int k = 0; k < 9; k++) {
            if(k==i || k==j){
            }else{
                result += num[k];
            }
        }
        return result;
    }

    
}