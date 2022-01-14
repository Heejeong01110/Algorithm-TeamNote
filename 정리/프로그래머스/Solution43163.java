import java.io.*;
import java.util.*;

public class Solution43163 {
    static int[] visited;
    static Integer result = 0;

    public static void main(String[] args) throws IOException {
        int answer = 0;
        String begin = "hit";
        String target = "cog";
        String[] words = { "hot", "dot", "dog", "lot", "log" };


        ArrayList<String> array = new ArrayList<String>();
        array.add(begin);

        visited = new int[words.length];
        
        dfs(array, target, words, 0);
        answer = result;
        System.out.println(answer);
        // return answer;
    }

    private static void dfs(ArrayList<String> current, String target, String[] words, Integer depth) {
        if (current.get(current.size() - 1).equals(target)) { // 성공
            result = depth;
            return;
        }

        if (depth > current.size() - 1) { //더이상 바꿀게 없을 때
            return;
        }

        ArrayList<Integer> list = changeOneWordList(current.get(depth), words); //한글자 차이 단어들
        for (int i = 0; i < list.size(); i++) {
            if (visited[list.get(i)] == 0) {
                current.add(words[list.get(i)]);
                visited[list.get(i)] = 1;

                dfs(current, target, words, depth + 1);

                current.remove(words[list.get(i)]);
                visited[list.get(i)] = 0;
            }
        }

        return;
    }
    
    private static ArrayList<Integer> changeOneWordList(String begin, String[] words) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < words.length;i++) {
            if (validateWord(begin, words[i])) {
                result.add(i);
            }
        }

        return result;
    }

    private static boolean validateWord(String begin, String word) {
        Integer correct = 0;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) == word.charAt(i)) {
                correct += 1;
            }
        }

        if (begin.length() - correct == 1) {
            return true;
        }
        return false;
    }
}
