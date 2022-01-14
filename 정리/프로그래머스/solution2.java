import java.io.*;
import java.util.*;

public class solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String answer = "";
        int n = 7;
        int[][] delivery = { { 5, 6, 0 }, { 1, 3, 1 }, { 1, 5, 0 }, { 7, 6, 0 }, { 3, 7, 1 }, { 2, 5, 0 } };
        
        Arrays.sort(delivery, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });


        HashMap<Integer,String> result = new HashMap<Integer, String>();
        for (int[] dele : delivery) {
            if (dele[2] == 1) {
                result.put(dele[0], "O");
                result.put(dele[1], "O");
            } else { //배송안된경우
                //1. 나머지 하나가 O이면 다른 하나는 무조건 X
                if (result.getOrDefault(dele[0], "?").equals("O")) {
                    result.put(dele[1], "X");
                } else if (result.getOrDefault(dele[1], "?").equals("O")) {
                    result.put(dele[0], "X");
                } else {
                    //X가 아닌 경우만 ? 들어감
                    if (!result.getOrDefault(dele[0], "?").equals("X")) {
                        result.put(dele[0], "?");
                    }
                    if (!result.getOrDefault(dele[1], "?").equals("X")) {
                        result.put(dele[1], "?");
                    }
                }
                //2.둘다 O 아닐경우에는 ?
            }
            bw.write(result + "\n");
        }

        


        for (int i = 1; i <= n; i++) {
            answer += result.getOrDefault(i, "?");
        }


        bw.write(answer + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
