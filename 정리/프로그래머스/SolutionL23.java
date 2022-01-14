import java.io.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class SolutionL23 {
    public static void main(String[] args) throws IOException {
        int n = 2;
        String[] words = { "hello", "one", "even", "never", "now", "world", "draw" };
        int[] answer = new int[2];

        Set<String> wordSet = new LinkedHashSet();
        Integer currentUser = 0;
        Integer round = 1;

        wordSet.add(words[0]);
        currentUser += 1;
        
        for (int i = 1; i < words.length; i++) {
            if (wordSet.contains(words[i])) {
                answer[0] = currentUser + 1;
                answer[1] = round;
                break;
            }

            wordSet.add(words[i]);

            if (words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
                answer[0] = currentUser + 1;
                answer[1] = round;
                break;
            }

            currentUser += 1;
            if(currentUser % n == 0){
                round += 1;
                currentUser-=n;
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
        return;
    }
}
