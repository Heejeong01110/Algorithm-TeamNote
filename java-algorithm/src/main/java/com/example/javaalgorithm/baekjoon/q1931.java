import java.io.*;
import java.util.*;

public class q1931{
public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Integer N = Integer.parseInt(br.readLine());
        String[] a = new String[2];
        Integer thread = 0;
        int[][] ar = new int[N][2];
        
        for(int i=0;i<N;i++){
            a = br.readLine().split(" ");
            ar[i][0] = Integer.parseInt(a[0]);
            ar[i][1] = Integer.parseInt(a[1]);
        }

        Arrays.sort(ar,new Comparator<int[]>(){

            @Override
            public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				
				return o1[1] - o2[1];
            }
        });

        int count = 0;
		int prev_end_time = 0;
		
		for(int i = 0; i < N; i++) {
			
			// 직전 종료시간이 다음 회의 시작 시간보다 작거나 같다면 갱신 
			if(prev_end_time <= ar[i][0]) {
				prev_end_time = ar[i][1];
				count++;
			}
		}
        bw.write(count+"\n");
        
        bw.flush();
        br.close();
        bw.close();
        

    }
}