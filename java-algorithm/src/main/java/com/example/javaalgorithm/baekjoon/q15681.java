import java.io.*;
import java.util.*;

public class q15681 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer N = Integer.parseInt(st.nextToken()); //정점의 수
        Integer R = Integer.parseInt(st.nextToken()); //루트의 번호
        Integer Q = Integer.parseInt(st.nextToken()); //쿼리의 수

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> neighbor = new HashMap<>();

        Integer U = 0;
        Integer V = 0;

        for (int i = 1; i <= N; i++) {
            map.put(i, new ArrayList<Integer>());
            neighbor.put(i, new ArrayList<Integer>());
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            U = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());

            map.get(U).add(V);
            map.get(V).add(U);
        }

        ArrayList<Integer> vertex = new ArrayList<>();
        for (int i = 0; i < Q; i++) {
            vertex.add(Integer.parseInt(br.readLine()));
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(R);
        boolean[] visited = new boolean[N+1];
        while (!queue.isEmpty()) {

            Integer current = queue.poll();

            visited[current] = true;

            for (int i = 0; i < map.get(current).size(); i++) {
                if (!visited[map.get(current).get(i)]) {
                    neighbor.get(current).add(map.get(current).get(i));
                    queue.add(map.get(current).get(i));
                }
            }
        }

        int[] dp = new int[N+1];
        calc(R, neighbor, dp);

        for (int i = 0; i < Q; i++) {
            bw.write(dp[vertex.get(i)]+"\n");
        }



        bw.flush();
        br.close();
        bw.close();
    }
    
    static Integer calc(Integer start, HashMap<Integer, ArrayList<Integer>> neighbor, int[] dp){
        if (neighbor.get(start).size() == 0) {
            dp[start] = 1;
            return dp[start];
        }

        if (dp[start] != 0) {
            return dp[start];
        }

        Integer result = 1;
        for (int i = 0; i < neighbor.get(start).size(); i++) {
            result += calc(neighbor.get(start).get(i), neighbor, dp);
        }
        dp[start] = result;

        return dp[start];
    }
    
    


}
