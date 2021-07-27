import java.io.*;
import java.util.*;

public class q2667 {
    static int cnt;

    static Integer N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        int[][] map = new int[N+1][N+1];
        boolean[][] memory = new boolean[N + 1][N + 1];
        int[] result = new int[N*N];

        StringBuilder sb;
        for (int i = 1; i <= N; i++) {
            sb = new StringBuilder(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(sb.substring(j - 1, j));
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] == 1 && !memory[i][j]) {
                    cnt++;
                    bfs(i, j, memory, map, result);
                }
            }
        }
        Arrays.sort(result);
        bw.write(cnt+"\n");

        for (int i = 0; i < result.length; i++) {
            if (result[i] != 0) {
                bw.write(result[i] + "\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    static void bfs(int x, int y, boolean[][] memory, int[][] map, int[] result) {
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(x, y));

        int[] xArr = { -1, 0, 1, 0 };
        int[] yArr = { 0, 1, 0, -1 };

        memory[x][y] = true;
        result[cnt] += 1;

        int testx = 0;
        int testy = 0;
        while (!queue.isEmpty()) {
            Location location = queue.poll();
            int curx = location.x;
            int cury = location.y;

            for (int i = 0; i < 4; i++) {
                testx = curx + xArr[i];
                testy = cury + yArr[i];

                if (checkLocation(testx, testy, memory, map)) {
                    queue.add(new Location(testx, testy));
                    memory[testx][testy] = true;
                    result[cnt] += 1;
                }
            }
        }


    }

    static boolean checkLocation(int x, int y, boolean[][] memory, int[][] map) {
        if (x < 1 || x >= N + 1 || y < 1 || y >= N + 1) {
            return false;
        }
        
        if (memory[x][y] || map[x][y] == 0) {
            return false;
        }
        return true;
    }

    static class Location {
        int x, y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
