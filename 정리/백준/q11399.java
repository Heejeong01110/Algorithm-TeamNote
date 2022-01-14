import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class q11399 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer N = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        ArrayList<Integer> ar = new ArrayList<>();
        Integer result = 0;
        for(int i=0;i<N;i++){
            ar.add(Integer.parseInt(split[i]));
        }

        ar.sort(Comparator.naturalOrder());
        result +=ar.get(0);
        for(int i=1;i<N;i++){ 
            ar.set(i, ar.get(i)+ar.get(i-1) );
            result += ar.get(i);
        }

        bw.write(result+"\n");

        
        


        br.close();
        bw.flush();
        bw.close();
    }


}
