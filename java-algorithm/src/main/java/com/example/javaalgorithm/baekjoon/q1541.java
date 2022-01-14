import java.io.*;

public class q1541 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        String[] number = a.split("\\-");
        String[] plusNumber;
        Integer result = 0;
        Integer plusResult = 0;

        for(int i=0;i<number.length;i++){
            plusNumber = number[i].split("\\+");
            for(int j=0;j<plusNumber.length;j++){
                plusResult += Integer.parseInt(plusNumber[j]);
            }

            if(i == 0){
                result = plusResult;

            }else{
                result -= plusResult;
            }
            plusResult = 0;

        }
        bw.write(result+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
