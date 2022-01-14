import java.io.*;
import java.util.*;

public class q19951 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    Integer N = Integer.parseInt(st.nextToken());
    Integer M = Integer.parseInt(st.nextToken());

    Integer[] result = new Integer[N+1];

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      result[i] = Integer.parseInt(st.nextToken());
    }
    
    int[] addSum = new int[N + 2];
    addSum[0] = 0;
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int swap = Integer.parseInt(st.nextToken());

      addSum[start] += swap;
      addSum[end + 1] -= swap;
    }

    int add = 0;
    for (int j = 1; j <= N; j++) {
      add += addSum[j];
      result[j] += add;
      System.out.print(result[j] + " ");
    }
    System.out.println("");

    br.close();
  }

}
