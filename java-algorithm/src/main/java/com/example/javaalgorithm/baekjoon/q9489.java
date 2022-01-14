import java.io.*;
import java.util.*;

public class q9489 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      Integer n = Integer.parseInt(st.nextToken()); // 노드 갯수
      Integer k = Integer.parseInt(st.nextToken()); // 계산할 K

      if (n == 0 && k == 0) {
        break;
      }

      Integer kIndex = 0;
      Integer[] parent = new Integer[n + 1];
      Integer[] ary = new Integer[n + 1];
      parent[0] = -1;
      ary[0] = -1;

      st = new StringTokenizer(br.readLine());
      for (int i = 1; i <= n; i++) {
        ary[i] = Integer.parseInt(st.nextToken());
        if (ary[i].equals(k)) {
          kIndex = i;
        }
      }

      Integer parents = -1;
      for (int i = 1; i <= n; i++) {
        if (ary[i] - ary[i - 1] > 1) { // 사촌
          parent[i] = ++parents;
        } else { // 형제
          parent[i] = parents;
        }
      }

      Integer result = 0;

      for (int i = 1; i <= n; i++) {
        System.out.println(i + " | 부모 : " + parent[i] + ", 조부모 : " + parent[parent[i]]);
        if (parent[i] != parent[kIndex] && parent[parent[i]] == parent[parent[kIndex]]) {
          result++;
        }
      }

      System.out.println(result);
    }
    

    br.close();
  }

}
