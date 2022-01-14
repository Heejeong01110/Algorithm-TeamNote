import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] n = { 2, 2 };
        String[][] data = { { "N~F=0", "R~T>2" }, { "M~C<2", "C~M>1" } };
        int[] answer = { 3648, 0 };

        for (int i = 0; i < answer.length; i++) {
            if (solution(n[i], data[i]) == answer[i]) {
                System.out.println("O");
            } else {
                System.out.println("X");
            }
        }
    }

    private static int solution(int n, String[] data) {
        int answer = 0;
        return answer;
    }
}
