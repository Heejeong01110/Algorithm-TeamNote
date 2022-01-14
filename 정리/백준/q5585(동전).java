import java.io.*;

public class q5585 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Integer money = Integer.parseInt(br.readLine());
        Integer n = 1000 - money;
        Integer count = 0;
            if(n/500 >0){
                count+=n/500;
                n=n%500;
            }
            if(n/100 >0){
                count+=n/100;
                n=n%100;
            }
            if(n/50 >0){
                count+=n/50;
                n=n%50;
            }
            if(n/10 >0){
                count+=n/10;
                n=n%10;
            }
            if(n/5 >0){
                count+=n/5;
                n=n%5;
            }
            if(n/1 >0){
                count+=n/1;
                n=n%1;
            }

            bw.write(count+"\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
