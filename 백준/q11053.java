import java.io.*;

public class q11053 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer N;
        N = Integer.parseInt(br.readLine());

        Integer A[] = new Integer[N];
        String tempS[] = new String[N];
        String temp;

        temp = br.readLine();
        tempS = temp.split(" ");
        for(int i=0;i<N;i++)    {
            A[i] = Integer.parseInt(tempS[i]);
        }
        
        for(int i=1;i<N;i++){ //제거할 갯수
            
        }



        br.close();
        bw.flush();
        bw.close();
    }
}
