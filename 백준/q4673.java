import java.io.*;
import java.util.*;

public class q4673 {
    static int N = 10000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Integer> result = new ArrayList<>();
        
        int[] memory = new int[N+1];



        for (int i = 1; i <= N; i++) {
            if (memory[i] == 0) {
                result.add(i);
                calc(i, memory);
            }
        }

        for (int i = 0; i < result.size(); i++) {
            bw.write(result.get(i) + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static void calc(int n, int[] memory) {
        if (memory[n] == 1) {
            return;
        }

        int temp = n;
        while (temp <= N) {
            if (memory[temp] == 1) {
                break;
            } else {
                memory[temp] = 1;
                n = temp;
            }
            
            temp = n + sumNumber(n);
        }

    }

    static int sumNumber(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

}
