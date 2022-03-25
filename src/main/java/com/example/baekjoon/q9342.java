package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class q9342 {

  private static int N;
  private static String[] ary;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    output(Solution());
  }

  private static void output(String result) {
    System.out.print(result);
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    ary = new String[N];

    for (int i = 0; i < N; i++) {
      ary[i] = br.readLine();
    }

    br.close();
  }

  private static String Solution() {
    StringBuilder sb = new StringBuilder();
    String regex = "(^[A-F]?A+F+C+[A-F]?$)";
    for(int i=0;i<N;i++){
      if(Pattern.matches(regex, ary[i])){
        sb.append("Infected!").append("\n");
      }else{
        sb.append("Good").append("\n");
      }
    }
    return sb.toString();
  }

}
