import java.io.*;
import java.util.*;

public class solution3 {
    public static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long[] answer = {};
        long n = 11*7;


        answer = new long[2];
        
        Integer result = 0;
        ArrayList<Long> array = new ArrayList<Long>();
        result = calc(n, 0, array,2);
        
        array.sort(Comparator.naturalOrder());

        if (result == 1) {
            answer[0] = -1;
            answer[1] = -1;
        } else {
            if (array.size() < 2) {
                answer[0] = -1;
                answer[1] = -1;
            } else {
                answer[0] = array.get(0);
                answer[1] = array.get(1);
            }
        }

        for (int i = 0; i < 2; i++) {
            bw.write(String.valueOf(answer[i]) + "\n");
        }
        

        bw.flush();
        br.close();
        bw.close();
    }

    //나누어지는 수가 1과 자기자신 제외하고 있으면 종료
    public static Integer calc(long number, int depth, ArrayList<Long> array,long start) {
        if (depth == 2) {
            System.out.println(array.toString());
            return 1;
        }
        
        while (start < number) {
            if (number % start == 0) {
                array.add(start);
                result = calc(number / start, depth + 1, array, start);
            } else {
                start++;
            }
            if (result == 1) {
                System.out.println(array.toString());
                return 1;
            }
            if (array.size() >= 2) {
                break;
            }
        }
        array.add(number);
        System.out.println(array.toString());
        return 0;

    }
}
