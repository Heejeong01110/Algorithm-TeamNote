import java.io.*;
import java.util.*;

public class q2178 {
    static int cnt;
    
    static Integer N;
    static Integer M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cnt = N * M;

        
        int[][] map = new int[N + 2][M + 2];
        int[][] memory = new int[N + 2][M + 2];

        StringBuilder sb;
        for (int i = 1; i <= N; i++) {
            sb = new StringBuilder(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(sb.substring(j - 1, j));
            }
        }

        bfs(1,1, memory,map);

        bw.write(memory[N][M] + "\n");

        

        //bw.write(location.size() + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
    
    static void bfs(int x, int y, int[][] memory, int[][] map) {
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(1, 1));

        // 상하좌우 칸을 표현하는데 사용할 배열
        int[] xArr = { -1, 0, 1, 0 };
        int[] yArr = { 0, 1, 0, -1 };

        memory[1][1] = 1;

        while (!queue.isEmpty()) {
            Location location = queue.poll();
            int curx = location.x;
            int cury = location.y;

            for (int i = 0; i < 4; i++) {
                int testx = curx + xArr[i];
                int testy = cury + yArr[i];

                if (checkLocation(testx, testy,memory,map)) {
                    queue.add(new Location(testx, testy));
                    memory[testx][testy] = memory[curx][cury] + 1;
                }
            }
        }
    }
    
    static boolean checkLocation(int x, int y,int[][] memory, int[][] map){
        if (x <= 0 || x >= N + 1 || y <= 0 || y >= M + 1) {
            return false;
        }
        
        if (memory[x][y] !=0 || map[x][y] == 0) {
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
