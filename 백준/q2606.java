import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class q2606 {
    
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); //컴퓨터 수
        int M = Integer.parseInt(br.readLine()); //컴퓨터 쌍의 수

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int memory[] = new int[N+1];
        int first;
        int twice;
        StringTokenizer st;

        for (int i = 1; i <= N; i++) {
            map.put(i, new ArrayList<Integer>());
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            first = Integer.parseInt(st.nextToken());
            twice = Integer.parseInt(st.nextToken());

            map.get(first).add(twice);
            map.get(twice).add(first);
        }

        memory[1] = 1;
        bfs(map, memory, 1);

        bw.write(result + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    
    static void bfs(HashMap<Integer, ArrayList<Integer>> map, int[] memory, int start) {

        for (int i = 0; i < map.get(start).size(); i++) {
            if (memory[map.get(start).get(i)] == 0) {
                memory[map.get(start).get(i)] = 1;
                bfs(map, memory, map.get(start).get(i));
                result += 1;
            }
        }
    }

}
