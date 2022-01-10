import java.io.*;
import java.util.*;

public class q6603 {
  static Integer[] S;
  static boolean[] visited;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    

    while (true) {
      String[] str = br.readLine().split(" ");
      Integer K = Integer.parseInt(str[0]);

      S = new Integer[K];
      visited = new boolean[K];

      if (K.equals(0)) {
        break;
      }

      for (int i = 0; i < K; i++) {
        S[i] = Integer.parseInt(str[i + 1]);
      }
      combination(0,0, S.length);
      sb.append('\n');

    }

    System.out.println(sb);
    br.close();
  }
  
  static private void combination(Integer start, Integer dep, Integer n) {
    if (dep == 6) {
      for (int i = 0; i < n; i++) {
        if (visited[i] == true) {
          sb.append(S[i] + " ");
        }
      }
      sb.append('\n');
      return;
    }

    for (int i = start; i < n; i++) {
      visited[i] = true;
      combination(i + 1, dep + 1,n);
      visited[i] = false; // 초기화
    }
  }
}
