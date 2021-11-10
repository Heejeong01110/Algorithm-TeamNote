
import java.io.*;
import java.util.*;

public class solution1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer = 0;
        int[] numbers = { 6, 1, 6, 6, 7, 6, 6, 7 };
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], map.getOrDefault(numbers[i], 0) + 1);
        }

        List<Integer> keySetList = new ArrayList<>(map.keySet());
        Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));

        
        answer = keySetList.get(0);
        if (map.get(keySetList.get(0)) <= numbers.length/2) {
            answer = -1;
        }



        bw.write(answer+ "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
