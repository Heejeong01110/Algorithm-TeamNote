import java.io.*;
import java.util.*;

public class q20365 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Integer N = Integer.parseInt(br.readLine());
    String str = br.readLine();

    Character color = str.charAt(0);
    Integer[] colorCount = new Integer[2];
    Integer temp = 0;

    colorCount[0] = 1;
    colorCount[1] = 0;

    for (int i = 1; i < str.length(); i++) {

      if (str.charAt(i) == color) {
      } else {
        temp = (temp == 1) ? 0 : 1;
        colorCount[temp] += 1;
        color = str.charAt(i);
      }
    }
    
    System.out.println(Math.min(colorCount[0], colorCount[1]) + 1);
    br.close();
  }

}
