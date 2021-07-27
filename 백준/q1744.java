import java.io.*;
import java.util.*;

public class q1744 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Integer[] map = new Integer[N];
        int result = 0;

        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(br.readLine());
        }

        int temp = 0;
        Arrays.sort(map, Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            if (map[i] >= 1) {
                temp = i;
            }
        }

        //>=1까지의 범위
        for (int i = 0; i < (temp - 1); i += 2) {
            result += Math.max(map[i] * map[i + 1], map[i] + map[i + 1]);
        }

        if ((temp+1) % 2 == 1) {
            result += map[temp];
        } else {
            result += Math.max(map[temp - 1] * map[temp], map[temp - 1] + map[temp]);
        }
        
        
        //음수가 있을때만 실행
        if (temp != N - 1) {
            //0이하 까지의 범위
            for (int i = N - 1; i > (temp + 1); i -= 2) {
                result += Math.max(map[i] * map[i - 1], map[i]);
            }

            if ((N - (temp + 1)) % 2 == 1) {
                result += map[temp+1];
            }
        }
        
        bw.write(result+"\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
