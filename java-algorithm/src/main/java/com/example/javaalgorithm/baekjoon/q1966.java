import java.io.*;
import java.util.*;

public class q1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer T = Integer.parseInt(br.readLine());
        Integer N = 0;
        Integer index = 0;
        StringTokenizer st;
        for (int i=0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            index = Integer.parseInt(st.nextToken());

            Integer[] queueList = new Integer[N];
            Integer[] maxList = new Integer[N];
            Queue<Integer> queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                queueList[j] = Integer.parseInt(st.nextToken());
                maxList[j] = queueList[j];
                queue.add(queueList[j]);
            }

            Arrays.sort(maxList, Collections.reverseOrder());
            int result = 0;
            int maxListCount = 0;

            
            while (!queue.isEmpty()) {
                if (maxList[maxListCount] == queue.peek()) {
                    if (index == 0) {
                        bw.write(++result + "\n");
                        break;
                    } else {
                        queue.poll();
                        maxListCount++;
                        result++;
                        index--;
                    }
                } else {
                    queue.add(queue.poll());
                    if (index == 0) {
                        index = queue.size()-1;
                    } else {
                        index--;
                    }
                }
            }


        }
        br.close();
        bw.flush();
        bw.close();
    }
}
