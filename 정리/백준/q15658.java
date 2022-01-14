import java.io.*;
import java.util.*;

public class q15658 {
  static ArrayList<int[]> map = new ArrayList<>();
  static int maxN = 0;
  static int minN = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;
    Integer N = Integer.parseInt(br.readLine());
    int[] num = new int[N];
    int[] pick = new int[4];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      num[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 4; i++) {
      pick[i] = Integer.parseInt(st.nextToken());
    }

    maxN = Integer.MIN_VALUE;
    minN = Integer.MAX_VALUE;
    dfs(1, num[0], N, pick, num);

    System.out.println(maxN + "\n" + minN);

    br.close();
  }


  public static void dfs(int idx, int sum, Integer n, int[] pick, int[] num) {
    if (idx == n) {
      minN = Math.min(minN, sum);
      maxN = Math.max(maxN, sum);
      return;
    }

    for (int i = 0; i < 4; i++) {
      if (pick[i] == 0)
        continue;
      pick[i]--;
      switch (i) {
        case 0:
          dfs(idx + 1, sum + num[idx], n, pick, num);
          break;
        case 1:
          dfs(idx + 1, sum - num[idx], n, pick, num);
          break;
        case 2:
          dfs(idx + 1, sum * num[idx], n, pick, num);
          break;
        case 3:
          dfs(idx + 1, sum / num[idx], n, pick, num);
          break;
      }
      pick[i]++;
    }
  }

}
