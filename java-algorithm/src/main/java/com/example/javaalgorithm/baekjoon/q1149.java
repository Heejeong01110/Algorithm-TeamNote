import java.io.*;
import java.util.StringTokenizer;


public class q1149 {
    static int[][] memory;
    static int[][] rgb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer N = Integer.parseInt(br.readLine());
        memory = new int[N][3];
        rgb = new int[N][3];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            rgb[i][0] = Integer.parseInt(st.nextToken()); //red
            rgb[i][1] = Integer.parseInt(st.nextToken()); //green
            rgb[i][2] = Integer.parseInt(st.nextToken()); //blue
        }

        for (int i = 0; i < N; i++) {
            if (i == 0) {
                memory[0][0] = rgb[0][0];
                memory[0][1] = rgb[0][1];
                memory[0][2] = rgb[0][2];
            }
            else {
                memory[i][0] = Math.min(memory[i - 1][1], memory[i - 1][2]) + rgb[i][0];
                memory[i][1] = Math.min(memory[i - 1][0], memory[i - 1][2]) + rgb[i][1];
                memory[i][2] = Math.min(memory[i - 1][0], memory[i - 1][1]) + rgb[i][2];
            }
        }

        

        bw.write(Math.min(memory[N-1][0], Math.min(memory[N-1][1], memory[N-1][2]))+ "\n");

        bw.flush();
        br.close();
        bw.close();
    }


    //1. 리턴값 : n번째 집을 칠하는 비용의 최솟값
    //2. 종료조건 :  n=1일때
    static int calc(int n, int color) {
        if (n == 0) {
            memory[0][0] = rgb[0][0];
            memory[0][1] = rgb[0][1];
            memory[0][2] = rgb[0][2];
            return memory[n][color];
        }

        if (memory[n][color] != 0) {
            return memory[n][color];
        }

        memory[n][0] = Math.min(calc(n - 1, 1), calc(n - 1, 2)) + rgb[n][0];
        memory[n][1] = Math.min(calc(n - 1, 0), calc(n - 1, 2)) + rgb[n][1];
        memory[n][2] = Math.min(calc(n - 1, 0), calc(n - 1, 1)) + rgb[n][2];

        return memory[n][color];
    }

}
