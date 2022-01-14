import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class q7568 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    Integer N = Integer.parseInt(br.readLine());
    Integer[][] person = new Integer[N][2];

    for (int i = 0; i < N; i++) {
      String[] str = br.readLine().split(" ");
      person[i][0] = Integer.parseInt(str[0]);
      person[i][1] = Integer.parseInt(str[1]);
    }
    
    for (int i = 0; i < N; i++) {
      Integer rank = 1;
      for (int j = 0; j < N; j++) {
        if (i == j) {
          continue;
        }

        // i 덩치 < j 덩치 ==> rank 값 증가
        if (person[i][0] < person[j][0] && person[i][1] < person[j][1]) {
          rank++;
        }
      }
      bw.write(rank + " ");
    }

    bw.flush();
    br.close();
    bw.close();
  }

}
