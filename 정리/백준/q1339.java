import java.io.*;
import java.util.*;

public class q1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer N = Integer.parseInt(br.readLine());
        char[] alphabet = new char[10];
        Integer[] alphabetNum = new Integer[10];
        String a;
        Integer alpcount = 0;
        Integer numCheck = 0;
        for(int i=0;i<10;i++){
            alphabetNum[i] = 0;
        }

        for(int i=0;i<N;i++){
            a = br.readLine();
            

            for(int j=0;j<a.length();j++){ //단어 앞에서부터 인덱스값
                //첫글자
                if(alpcount == 0){
                    alphabet[0] = a.charAt(0);
                    alphabetNum[0] += (int)Math.pow(10, a.length() - 1);
                    alpcount+=1;
                }else{
                    //이미 사용한 알파벳인지 확인
                    for(int k=0;k<alpcount;k++){
                        if(alphabet[k] == a.charAt(j)){//이미 나온 글자인 경우
                            alphabetNum[k] += (int)Math.pow(10, a.length()-j-1);
                            numCheck=1; //체크
                        }
                    }

                    if(numCheck==0){ //처음나온 글자인 경우
                        alphabet[alpcount] = a.charAt(j);
                        alphabetNum[alpcount] += (int)Math.pow(10, a.length()-j-1);
                        alpcount+=1;
                        numCheck=1; //체크
                    }

                    numCheck = 0;
                }
                
            }
        }

        Arrays.sort(alphabetNum,Comparator.reverseOrder());
        //Arrays.sort(alphabetNum);
        Integer result = 0;
        Integer multinum = 9;
        for(int i=0;i<alpcount;i++){
            result += alphabetNum[i]*multinum;
            multinum-=1;
        }
        bw.write(result+"\n");

        br.close();
        bw.flush();
        bw.close();

    }

}
