import java.io.*;
import java.util.*;

public class q2468 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //y
        int M = Integer.parseInt(st.nextToken()); //x
        int K = Integer.parseInt(st.nextToken());

        int[][] memory = new int[N][M];
        ArrayList<Integer> result = new ArrayList<>();

        int sx, ex, sy, ey;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());
            ex = Integer.parseInt(st.nextToken());
            ey = Integer.parseInt(st.nextToken());

            for (int j = sy; j < ey; j++) {
                for (int k = sx; k < ex; k++) {
                    memory[j][k] = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (memory[i][j] == 0) {
                    result.add(dfs(memory, i, j, N, M));
                }
            }
        }

        bw.write(result.size() + "\n");
        result.sort(Comparator.naturalOrder());
        for (int i = 0; i < result.size(); i++) {
            bw.write(result.get(i) + " ");
        }
        bw.write("\n");

        bw.flush();
        br.close();
        bw.close();
    }

    static int dfs(int[][] memory, int row, int col,int N,int M) {
        int result = 0;
        int[] location = new int[2];
        Queue<int[]> queue = new LinkedList<>();

        int[] dx = { 0, 1, 0, -1 };
        int[] dy = { 1, 0, -1, 0 };

        location[0] = col; //x
        location[1] = row; //y

        queue.add(location);

        while (!queue.isEmpty()) {
            int x = queue.peek()[0];
            int y = queue.poll()[1];
            memory[y][x] = 1;
            result += 1;

            for (int i = 0; i < 4; i++) {
                if (x + dx[i] >= 0 && x + dx[i] < M && y + dy[i] >= 0 && y + dy[i] < N) {
                    if (memory[y + dy[i]][x + dx[i]] == 0) {
                        location = new int[2];
                        location[0] = x + dx[i];
                        location[1] = y + dy[i];
                        memory[y + dy[i]][x + dx[i]] = 2;
                        queue.add(location);
                    }
                }
            }

        }

        return result;
    }

}
