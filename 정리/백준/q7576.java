import java.io.*;
import java.util.*;

public class q7576 {
    static int[] pointArray; // 익은 토마토일 경우 1, 아닐경우 0, 들어있지 않을 경우 -1
    static Queue<Integer> queue = new LinkedList<>();
    static ArrayList<ArrayList<Integer>> ar = new ArrayList<ArrayList<Integer>>();
    static int depthCount = 0;
    static int endNum = -1;

    public static void main(String[] args) throws IOException {
        /*
         * 1 : 익은 토마토 0 : 익지 않은 토마토 -1 : 토마토가 들어있지 않은 칸
         * 
         * M : 가로 칸의 수 N : 세로 칸의 수
         * 
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Integer M = Integer.parseInt(st.nextToken());
        Integer N = Integer.parseInt(st.nextToken());

        pointArray = new int[N * M]; // 익은 토마토일 경우 1, 아닐경우 0, 들어있지 않을 경우 -1
        queue = new LinkedList<>();

        for (int i = 0; i < N * M; i++) {
            ar.add(new ArrayList<Integer>());
        }

        // 초기화
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < M; j++) {
                pointArray[i * M + j] = Integer.parseInt(st.nextToken());
                if (pointArray[i * M + j] != -1) {

                    if (j > 0 && (pointArray[i * M + j - 1] != -1)) {
                        ar.get(i * M + j).add(i * M + j - 1);
                        ar.get(i * M + j - 1).add(i * M + j);

                    }

                    if (i > 0 && (pointArray[(i - 1) * M + j] != -1)) {
                        ar.get(i * M + j).add((i - 1) * M + j);
                        ar.get((i - 1) * M + j).add(i * M + j);
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < N * M; i++) {
            if (pointArray[i] == 1) {
                queue.add(i);
                pointArray[i] = 2;
                count+=1;
                endNum = i;
            }
        }

        wbfs(endNum,N,M,count);

        for (int i = 0; i < N * M; i++) {
            if ((pointArray[i] == 0)) {
                bw.write("-1\n");
                bw.flush();
                bw.close();
                br.close();
                return;
            }
        }

        bw.write(depthCount + "\n");

        bw.flush();
        bw.close();
        br.close();

    }
    /* pointArray = new int[N * M]; //큐내부에 위치 - 2, 익은 토마토일 경우 1, 아닐경우 0, 들어있지 않을 경우 -1*/
    static void wbfs(Integer s,Integer N, Integer M,Integer currentNum){
        Integer countNum = 0;
        while(true){

            if(queue.size() == 0){
                return;
            }

            for (int j = 0; j < ar.get(queue.peek()).size(); j++) {
                if (pointArray[ar.get(queue.peek()).get(j)] == 0) {
                    queue.offer(ar.get(queue.peek()).get(j));
                    pointArray[ar.get(queue.peek()).get(j)] = 2;
                    countNum+=1;
                }
            }
            pointArray[queue.peek()] = 1;
            currentNum-=1;

            if(currentNum==0 && queue.size() !=1){
                currentNum = countNum;
                countNum = 0;
                depthCount+=1;
            }
            queue.poll();

        }

    }
}
