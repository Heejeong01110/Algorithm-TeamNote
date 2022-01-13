import java.io.*;
import java.util.*;

public class q10798 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = new String[5];
    int maxStrLen = 0;
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < 5; i++) {
      input[i] = br.readLine();
      maxStrLen = Math.max(maxStrLen, input[i].length());
    }

    for (int i = 0; i < maxStrLen; i++) {
      for (int j = 0; j < 5; j++) {
        if (input[j].length() > i) {
          sb.append(input[j].charAt(i));
        }
      }
    }

    System.out.println(sb.toString());
    br.close();
  }

}
