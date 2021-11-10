import java.io.*;
import java.util.*;

public class Solution43163 {
    
    public static void main(String[] args) throws IOException {
        String[] begins = { "hit" , "hit"};
        String[] targets = { "cog", "cog"};
        ArrayList<String[]> wordss = new ArrayList<>();
        String[] w1 = { "hot", "dot", "dog", "lot", "log", "cog" };
        wordss.add(w1);
        String[] w2 = { "hot", "dot", "dog", "lot", "log" };
        wordss.add(w2);

        for (int i=0;i< begins.length;i++) {
            String begin = begins[i];
            String target = targets[i];
            String[] words = wordss.get(i);
            System.out.println(solution(begin, target, words));
        }
    }

    private static int solution(String begin, String target, String[] words) {
        int answer = 0;
        ArrayList<String> array = new ArrayList<String>();
        array.add(words[0]);
        Integer[] visited = new Integer[words.length];

        answer = dfs(array, target, words, 1, visited);
        return answer;
    }
    
    private static Integer dfs(ArrayList<String> current, String target, String[] words, Integer depth) {
        if (current.get(current.size() - 1).equals(target)) { //성공
            return depth;
        }

        if (depth > current.size() - 1) { //더이상 바꿀게 없을 때
            return 0;
        }

        for (String word : words) {
            
        }


        return 0;
    }
}
