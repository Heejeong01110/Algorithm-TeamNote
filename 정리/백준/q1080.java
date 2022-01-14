import java.io.*;
import java.util.StringTokenizer;

public class q1080 {
    static Integer N;
    static Integer M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;
        N = Integer.parseInt(st.nextToken()); //3
        M = Integer.parseInt(st.nextToken()); //4

        int[][] map1 = new int[N][M]; //[3][4]
        int[][] map2 = new int[N][M]; // [3][4]
        /*
        0 0 0 0       1 0 0 1
        0 0 1 0   ->  1 0 1 1
        0 0 0 0       1 0 0 1
        */
        //원본
        String a = "";
        for (int i = 0; i < N; i++) {
            a = br.readLine();
            for (int j = 0; j < M; j++) {
                map1[i][j] = Character.getNumericValue(a.charAt(j));
            }
        }
        
        //결과본
        for (int i = 0; i < N; i++) {
            a = br.readLine();
            for (int j = 0; j < M; j++) {
                map2[i][j] = Character.getNumericValue(a.charAt(j));
            }
        }

        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 2; j++) {

                if (map1[i][j] != map2[i][j]) {
                    result += 1;
                    for (int k = 0; k < 3; k++) {
                        for (int m = 0; m < 3; m++) {
                            map1[i + k][j + m] = (map1[i + k][j + m] == 1 ? 0 : 1);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map1[i][j] != map2[i][j]) {
                    bw.write("-1\n");
                    bw.flush();
                    br.close();
                    bw.close();
                    return;
                }

            }
        }


        bw.write(result + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
    


}
