import java.io.*;
import java.util.*;

public class q4796 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        Integer L = 0;//L일동안 사용 가능
        Integer P = 0;//연속하는 P일 중
        Integer V = 0;//V일 짜리 휴가 시작

        Integer caseCount = 0;

        while(true){
            
            st = new StringTokenizer(br.readLine()," ");
            
            L = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());

            if(L==0 && P==0 && V==0){
                break;
            }

            bw.write("Case "+(caseCount+1)+": "+((V/P)*L + ((V % P>L)?L:V % P))+"\n");
            caseCount+=1;
            
        }

        br.close();
        bw.flush();
        bw.close();


    } 
}
