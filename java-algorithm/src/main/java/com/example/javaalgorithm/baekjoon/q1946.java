import java.io.*;
import java.util.*;

public class q1946 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Integer testCase = Integer.parseInt(br.readLine());
        Integer number=0;
        String[] a= new String[2];
        
        
        for(int i=0;i<testCase;i++){
            number = Integer.parseInt(br.readLine());
            int[][] level = new int[number][2];
            for(int j=0;j<number;j++){
                a=br.readLine().split(" ");
                level[j][0] = Integer.parseInt(a[0]);
                level[j][1] = Integer.parseInt(a[1]);
            }

            Arrays.sort(level,new Comparator<int[]>(){

                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            int count = 1;
            int maxlevel =level[0][1]; 
            for(int j=0;j<number;j++){
                if(level[j][1] < maxlevel){
                    count+=1;
                    maxlevel =level[j][1]; 
                }
            }

            bw.write(count+"\n");

        }


        //bw.write(result+"\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
