import java.io.*;
import java.util.*;

public class q14503 {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static int N;
    static int M;
    
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int[] location = new int[3];

        st = new StringTokenizer(br.readLine());
        location[0] = Integer.parseInt(st.nextToken());
        location[1] = Integer.parseInt(st.nextToken());
        location[2] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(map, location);
        bw.write(result + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
    
    static void dfs(int[][] map, int[] location) {
        if (map[location[0]][location[1]] == 0) {
            map[location[0]][location[1]] = -1;
            result += 1;
        }
        
        for (int i = 0; i < 4; i++) {
            int row = location[0] + dr[(location[2] + i) % 4];
            int col = location[1] + dc[(location[2] + i) % 4];

            if (map[row][col] == 0) {
                location[2] = (location[2] + i) % 4;
                location[0] = row;
                location[1] = col;
                dfs(map, location);
            }
        }

        switch (location[2]) {
            case 0:
                if (map[location[0] + 1][location[1]] == 1) {
                    return;
                }
                location[0] += 1;
                break;
            case 1:
                if (map[location[0]][location[1]+1] == 1) {
                    return;
                }
                location[1] += 1;
                break;
            case 2:
                if (map[location[0] - 1][location[1]] == 1) {
                    return;
                }
                location[0] -= 1;
                break;
            case 3:
                if (map[location[0]][location[1] - 1] == 1) {
                    return;
                }
                location[1] -= 1;
                break;
        }
        dfs(map, location);
    }
    



}
