import java.io.*;
import java.util.*;

public class Solution67258 {
    static Integer result = 0;
    static int[] resultList;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        ArrayList<String[]> operationss = new ArrayList<>();
        String[] g1 = { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        String[] g2 = { "AA", "AB", "AC", "AA", "AC"};
        String[] g3 = { "XYZ", "XYZ", "XYZ"};
        String[] g4 = { "ZZZ", "YYY", "NNNN", "YYY", "BBB" };
        operationss.add(g1);
        operationss.add(g2);
        operationss.add(g3);
        operationss.add(g4);

        for (String[] operations : operationss) {
            System.out.println(Arrays.toString(solution(operations)));
        }
    }

    private static int[] solution(String[] gems) {
        int[] answer = { 0, 0 };
        HashSet<String> word = new HashSet<>();
        visited = new int[gems.length];
        result = gems.length;
        resultList = new int[word.size()];


        for (int i = 0; i < gems.length; i++) {
            word.add(gems[i]);
        }

        ArrayList<String> wordList = new ArrayList<>();
        wordList.addAll(word);

        // dfs(gems, wordList, 0, new int[word.size()]);
        // answer[0] = resultList[0] + 1;
        // answer[1] = resultList[word.size()-1] + 1;



        // 범위
        int left = 0;
        int right = 0;

        // 정답
        int start = 0;
        int end = 0;
        HashMap<String, Integer> map = new HashMap<>();

        while(true){
            if (word.size() == map.size()) {
                
            }
        }





        

        return answer;
    }

    
    private static void dfs(String[] gems, ArrayList<String> word, Integer index, int[] currentList) {
        if (index >= word.size()) { //모두 선택했을때
            int[] sortList = currentList.clone();
            Arrays.sort(sortList);
            Integer width = sortList[word.size()-1] - sortList[0];
            if (result > width) {
                result = width;
                resultList = sortList;
                return;
            }
            return;
        }

        ArrayList<Integer> indexWords = findWordsIndex(gems, word.get(index));
        for (int i = 0; i < indexWords.size(); i++) {
            if(visited[indexWords.get(i)] == 0){
                visited[indexWords.get(i)] = 1;
                currentList[index] = indexWords.get(i);

                dfs(gems, word, index + 1, currentList);

                visited[indexWords.get(i)] = 0;
                currentList[index] = 0;
            }
        }
    }
    
    private static ArrayList<Integer> findWordsIndex(String[] gems, String word) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < gems.length; i++) {
            if (gems[i].equals(word)) {
                result.add(i);
            }
        }
        return result;
    }
}
