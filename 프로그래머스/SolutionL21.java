import java.io.*;
import java.util.*;

public class SolutionL21 {
    static Integer minK;
    public static void main(String[] args) throws IOException {
        int n=5000;
        int ans = 0;
        minK = n;

        dfs(n, 1, 1);

        System.out.println(minK);
        return;
    }

    public static void dfs(int n, Integer current, Integer k) {
        if (minK <= k || current>n) {
            return;
        }
        if (current == n) {
            if (minK > k) {
                minK = k;
            }
            return;
        }

        dfs(n, current * 2, k);
        dfs(n, current +1, k+1);
        return;
    }
}
