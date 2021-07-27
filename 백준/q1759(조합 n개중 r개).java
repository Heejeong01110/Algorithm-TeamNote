import java.io.*;
import java.util.*;

public class q1759 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer L; //암호 size
        Integer C; //주어질 알파벳 갯수
        String readTemp;
        ArrayList<Character> alpabat = new ArrayList<Character>();
        String[] reader = new String[2];
        

        //readTemp = br.readLine();
        reader = br.readLine().split(" ");
        L = Integer.parseInt(reader[0]);
        C = Integer.parseInt(reader[1]);

        readTemp = br.readLine();
        for (int i=0;i<C;i++) {
            alpabat.add(readTemp.charAt(i*2));
        }


        Integer[] aIsm = new Integer[C];
        Collections.sort(alpabat);
        Character[] alpabatch = new Character[C];

        for(int i=0;i<C;i++){
            if(alpabat.get(i).equals('a')||alpabat.get(i).equals('e')||alpabat.get(i).equals('i')||
            alpabat.get(i).equals('o')||alpabat.get(i).equals('u')){
                aIsm[i] = 1;//모음
            }else{
                aIsm[i] = 0;//자음
            }
            alpabatch[i] = alpabat.get(i);
        }
        Integer[] resultarr = new Integer[L];
        Combination(alpabatch,C,L,0,0,resultarr,aIsm);

        br.close();
    }
    
    
    //조합 사용 n개 중 r개 뽑기
    static void Combination(Character[] arr, int n, int r, int index, int target, Integer[] resultarr, Integer[] aIsm){
        if(r<=0){
            Integer sum = 0;
            for(int i=0;i<resultarr.length;i++){
                sum += aIsm[resultarr[i]];
            }

            if(sum>=1 && sum<=resultarr.length-2){
                for(int i=0;i<resultarr.length;i++){
                    System.out.print(arr[resultarr[i]]);
                }
                System.out.println("");
            }
        }else if(target >=n){
            return;
        }else{
            resultarr[index] =  target;            // 결과 차례일 때 이번 target(원본의 인덱스) 값으로 덮어쓸것인지
                                                    // 뽑을경우 index가 올라가 자연스럽게 값이 저장
                                                    // 안뽑을 경우 index가 올라가지 않아 다음 target 값으로 덮어씌워짐
            //뽑았을 때
            Combination(arr,n,r-1,index+1,target+1,resultarr,aIsm);
            //안뽑았을 때
            Combination(arr,n,r,index,target+1,resultarr,aIsm);
        }
    }

}
