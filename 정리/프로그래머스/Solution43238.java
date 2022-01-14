import java.io.*;
import java.util.*;

public class Solution43238 {
    public static void main(String[] args) throws IOException {
        int n = 6;
        int[] times = { 10, 1 };
        long answer = 0;



        //1. 이분탐색
        Arrays.sort(times);

        long low = 0;
        long high = (long)times[times.length - 1] * n; //6
        long mid = 0;

        while (low <= high) {
            mid = (low + high) / 2; //30
            long sum = 0;
            for (long time : times) {
                sum += mid / time; //mid 시간까지 사용한 사람 수
            }
            if (sum >= n) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        System.out.println(answer);





        //2. 우선순위 큐

        if (times.length == 1) {
            answer = times[0] * n;
        }

        PriorityQueue<Integer[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < times.length; i++) {
            Integer[] item = new Integer[2];
            item[0] = times[i];
            item[1] = times[i];
            queue.add(item);
        }

        int tempN = n;
        int index = 0;
        while (tempN > 0) {
            Integer[] currentTime = new Integer[2];
            Integer[] tempItem = new Integer[2];
            currentTime = queue.poll();
            tempN--;

            if (tempN == 0) {
                answer = currentTime[0];
            }

            tempItem[0] = currentTime[0] + currentTime[1];
            tempItem[1] = currentTime[1];
            queue.add(tempItem);
            index = (index + 1) % times.length;
            
        }

        System.out.println(answer);
            
    }
    

}
