package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class q2204 {

  private static int N;
  private static String[] words;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    N = Integer.parseInt(br.readLine());
    String result;
    String rowVersion;
    String rowVersion2;
    while (N != 0) {
      words = new String[N];

      for (int i = 0; i < N; i++) {
        words[i] = br.readLine();
      }

      Arrays.sort(words, Comparator.naturalOrder());

      result = words[0];
      rowVersion = result.toLowerCase(Locale.ROOT);
      for (int i = 1; i < N; i++) {
        rowVersion2 = words[i].toLowerCase(Locale.ROOT);
        if (!compare(rowVersion, rowVersion2)) { //새로운 글자가 더 앞
          result = words[i];
          rowVersion = result.toLowerCase(Locale.ROOT);
        }
      }
      sb.append(result).append("\n");
      N = Integer.parseInt(br.readLine());
    }
    System.out.print(sb.toString());
    br.close();
  }

  private static boolean compare(String rowVersion, String rowVersion2) { //true일 경우 1번이 더 앞
    int compare = 0;
    int len = Math.min(rowVersion.length(), rowVersion2.length());
    for (int i = 0; i < len; i++) {
      if (rowVersion.charAt(i) > rowVersion2.charAt(i)) {
        compare = -1;
        break;
      } else if (rowVersion.charAt(i) < rowVersion2.charAt(i)) {
        compare = 1;
        break;
      }
    }

    if (compare == 0) { //모두 일치할 경우
      return rowVersion.length() <= rowVersion2.length();
    }

    return compare > 0;
  }


}
