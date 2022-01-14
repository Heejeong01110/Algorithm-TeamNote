import java.io.*;

public class q1248 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer N = Integer.parseInt(br.readLine());
        String array;
        String[][] arrayPM = new String[N][N];
        int[] arrayResult = new int[N]; //정답 저장
        Integer num=0;
        array = br.readLine();
        for(int i=0; i<N;i++){
            for(int j=i; j<N;j++){
                arrayPM[i][j] = String.valueOf(array.charAt(num++));           
            }
            arrayResult[i] = -10;
        }

        num = 0;

        calculator(0,arrayPM,arrayResult);

        for(int i=0;i<N;i++){
            bw.write(arrayResult[i]+" ");
        }
        bw.write("\n");

        br.close();
        bw.flush();
        bw.close();
    }

    //num이 해당 칸[col][row]의 조건을 만족했을 경우, 다음 깊이로 이동
    //마지막 깊이의 숫자가 조건을 만족했을 경우 종료
    //해당 칸의 조건을 만족하지 못했을 경우 이전 깊이로 이동
    //조건 : 자기 col보다 낮은 수인 조건 모두 만족



    //해당 자리의 값이 조건을 만족하는지 확인
    static void calculator(Integer row, String[][] arrayPM, int[] arrayResult){
        int result = 0;
        int count = -10;
        //탈출조건
    
        boolean temp = true;
        if(row == 4){
            return;
        }
        while(count<=10){
            result = 0;
            temp = true;
            //count값 바로 arrayResult에 넣어주기
            
            for(int i=row;i>=0;i--){ //현재 깊이만큼 연산([2]이면 3개 검증)
                result +=arrayResult[i];

                if(cal(result,arrayPM[i][row])){
                    //참일 경우 i--;
                    //연산이 모두 true일 경우 다음 깊이로 이동
                    
                    //연산이 첫번째 바퀴만 맞았을 경우
                }else{
                    temp = false;
                    //연산 중 틀린값이 있을 경우 for문 종료 후 count ++
                    //현재 깊이에서 count 가 10을 넘었을 경우 이전 깊이에서 ++ 해줘야함

                    count ++;
                    if(count<=10){
                        arrayResult[row] = count;
                    }
                    
                    i=0; //for문 바로 종료
                }
            }

            if(temp){
                calculator(row+1,arrayPM,arrayResult);
                count++;
            }
            
        }
        //재귀 탈출조건 : 10이 넘을 경우 이전 레벨로 이동
        return;
        
    }


    static boolean cal(Integer result, String arrayPM){
        boolean re = false;
        switch (arrayPM){
            case "+":
                if(result >0){
                    re = true;
                }
                break;
            case "-":
            if(result <0){
                re = true;
            }
                break;
            case "0":
            if(result == 0){
                re = true;
            }
                break;
            default:
                break;
        }

        return re;
    }

    
}
