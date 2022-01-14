import java.io.*;
import java.util.*;

public class q1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Integer N=Integer.parseInt(st.nextToken());//물이 새는 곳의 개수
        Integer L=Integer.parseInt(st.nextToken());//테이프의 길이
        ArrayList<Integer> location = new ArrayList<>();

        st = new StringTokenizer(br.readLine()," ");
        for (int i=0;i<N;i++){
            location.add(Integer.parseInt(st.nextToken()));
        }
        location.sort(Comparator.naturalOrder());
        
        Integer Nnum = N;
        for (int i=0;i<Nnum-1;i++){
            if((location.get(i+1) - location.get(i)) <= L-1){
                location.remove(i+1);
                Nnum--;
                i--;
            }
        }

        bw.write(location.size()+"\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
