import java.io.*;

public class q2839 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Integer N;
        Integer fiveU=0;
        Integer threeU=0;

        N = Integer.parseInt(br.readLine());
        /*
        fiveU = N/5;
        while(true){
            if(fiveU<0 || threeU <0){
                bw.write("-1\n");
                break;
            }else if(fiveU*5+threeU*3 == N){
                bw.write(fiveU+threeU+"\n");
                break;
            }

            if(fiveU*5+threeU*3>N){
                fiveU-=1;
                threeU=0;
            }else{
                threeU+=1;
            }
        }
        */

        threeU = N/3;
        Integer nn = N%3;
        Integer a;
        if(nn==0&&N>=3){
            a = threeU/5;
            fiveU = a*3;
            threeU -= a*5;
            bw.write(fiveU +threeU +"\n");
        }else if(nn==2&&N>3){
            fiveU +=1;
            threeU-=1; //나머지 2개 포함시킴

            a = threeU/5;
            fiveU += a*3;
            threeU -= a*5; //3봉투 -> 5봉투 변환
            bw.write(fiveU +threeU +"\n");
        }else if(nn==1&&N>3){
            if(threeU<3){
                bw.write("-1\n");
            }else{
                threeU-=3;
                fiveU +=2;

                a = threeU/5;
                fiveU += a*3;
                threeU -= a*5;
                bw.write(fiveU +threeU +"\n");
            }
        }else{
            bw.write("-1\n");
        }
        


        br.close();
        bw.flush();
        bw.close();


    } 
}
