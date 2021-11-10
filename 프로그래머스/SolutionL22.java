import java.io.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class SolutionL22 {
    public static void main(String[] args) throws IOException {
        int n = 3;
        String[] words = { "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank" };
        int[] answer = {};

        Set<String> wordSet = new LinkedHashSet();
        Integer currentUser = 0;
        
        for (int i = 1; i < words.length; i++) {
            if (wordSet.contains(words[i])) {
                answer[0] = currentUser+1;
                answer[1] = i + 1;
                break;
            }

            wordSet.add(words[i]);

            if (words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
                answer[0] = currentUser+1;
                answer[1] = i + 1;
                break;
            }

            currentUser = (currentUser + 1) % 3;
        }

        System.out.println(answer[0] + " " + answer[1]);
        return;
    }

}
