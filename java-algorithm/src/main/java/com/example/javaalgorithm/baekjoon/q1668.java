import java.io.*;
import java.util.*;

public class q1668 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Integer N = Integer.parseInt(br.readLine()); //트로피 갯수
    Integer[] ary = new Integer[N];

    Integer resultL = 0;
    Integer high = 0;
    for (int i = 0; i < N; i++) {
      ary[i] = Integer.parseInt(br.readLine());
      if (high < ary[i]) {
        resultL += 1;
        high = ary[i];
      }
    }

    Integer resultR = 0;
    high = 0;
    for (int i = N - 1; i >= 0; i--) {
      if (high < ary[i]) {
        resultR += 1;
        high = ary[i];
      }
    }

    System.out.println(resultL+"\n"+resultR);
    br.close();

  }

}
