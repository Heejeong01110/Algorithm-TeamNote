package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q18119 {

  private static int N;
  private static int M;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    int result = 0;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    int alp = 0;
    for (int i = 0; i < 26; i++) {
      alp += (1 << i);
    }

    String str;
    int[] dict = new int[N];
    for (int i = 0; i < N; i++) {
      str = br.readLine();
      for (int j = 0; j < str.length(); j++) {
        dict[i] |= (1 << (str.charAt(j) - 'a'));
      }
    }

    int command, letter;
    for (int i = 0; i < M; i++) {
      String query = br.readLine();
      command = Integer.parseInt(String.valueOf(query.charAt(0)));
      letter = query.charAt(2) - 'a';

      if (command == 1) {
        alp &= ~(1 << letter);
      } else if (command == 2) {
        alp |= (1 << letter);
      }

      for (int j = 0; j < N; j++) {
        if ((dict[j] & alp) == dict[j]) {
          result++;
        }
      }
      sb.append(result + "\n");
      result = 0;
    }
    System.out.print(sb.toString());
    br.close();
  }

}
