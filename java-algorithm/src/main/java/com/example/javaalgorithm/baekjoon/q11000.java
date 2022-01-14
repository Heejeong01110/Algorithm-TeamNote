import java.io.*;
import java.util.*;

public class q11000 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] map = new int[N][2];
        int result = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(map, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }

                return o1[0] - o2[0];
            }
        });


        queue.add(map[0][1]);

        for (int i = 1; i < N; i++) {
            if (queue.peek() <= map[i][0]) {
                //마지막 시간보다 시작시간이 작을 때 --> 새로운 강의실 필요
                queue.poll();
                queue.add(map[i][1]);
            } else {
                queue.add(map[i][1]);
            }
        }
        result = queue.size();
        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
