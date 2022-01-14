import java.io.*;
import java.util.*;

public class q1942 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;
    String[][] clock = new String[3][2];

    for (int i = 0; i < 3; i++) {
      st = new StringTokenizer(br.readLine());
      clock[i][0] = st.nextToken();
      clock[i][1] = st.nextToken();
    }

    for (int i = 0; i < 3; i++) {
      System.out.println(calc(clock[i]));

    }

    br.close();
  }

  static Integer calc(String[] clock) {
    Integer[] start = new Integer[3];
    Integer[] endStr = new Integer[3];

    for (int i = 0; i < 3; i++) {
      start[i] = Integer.parseInt(clock[0].substring(0,2));
    }

    Integer[] current = new Integer[3];
    while (!current.equals(clock[1])) {
      
    }

    

    return null;
  }

  static Integer[] convertToIntegerList(String[] clock) {
    Integer[] result = new Integer[3];

    for (int i = 0; i < 3; i++) {
      result[i] = Integer.parseInt(clock[i]);
    }
    return result;
  }

}
