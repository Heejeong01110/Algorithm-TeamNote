import java.io.*;
import java.util.*;

public class q11659 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    Integer N = Integer.parseInt(st.nextToken());
    Integer M = Integer.parseInt(st.nextToken());
    Integer[] ary = new Integer[N+1];
    
    ary[0] = 0;
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      ary[i] = ary[i-1] + Integer.parseInt(st.nextToken());
    }

    Integer start;
    Integer end;
    for (int i = 1; i <= M; i++) {
      st = new StringTokenizer(br.readLine());
      start = Integer.parseInt(st.nextToken());
      end = Integer.parseInt(st.nextToken());

      System.out.println(ary[end] - ary[start-1]);

      
    }

    br.close();
  }

}
