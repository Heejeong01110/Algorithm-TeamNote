package com.example.baekjoon;

import java.io.*;
import java.util.*;

public class q1942 {
  private static String[][] clock = new String[3][2];

  public static void main(String[] args) throws IOException {
    inputData();

    for (int i = 0; i < 3; i++) {
      System.out.println(calc(clock[i]));
    }

  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    for (int i = 0; i < 3; i++) {
      st = new StringTokenizer(br.readLine());
      clock[i][0] = st.nextToken();
      clock[i][1] = st.nextToken();
    }

    br.close();
  }

  static Integer calc(String[] clock) {
    Integer[] start = convertToIntegerList(clock[0]);
    Integer[] end = convertToIntegerList(clock[1]);

    Integer[] time = start.clone();
    int count = 0;
    int timeInt;

    while (!Arrays.equals(time, end)) {
      if(Arrays.equals(time, start)){
        timeInt = getTimeInt(time);
        if(timeInt % 3 == 0){
          count += 1;
        }
      }

      time[2]++;
      if (time[2] == 60) {
        time[1] += 1;
        time[2] = 0;
      }

      if (time[1] == 60) {
        time[0] += 1;
        time[1] = 0;
      }

      if (time[0] == 24) {
        time[0] = 0;
      }

      timeInt = getTimeInt(time);
      if(timeInt % 3 == 0){
        count += 1;
      }

    }
    return count;
  }

  private static int getTimeInt(Integer[] time) {
    return time[0] * 1000 + time[1] * 100 + time[2];
  }

  static Integer[] convertToIntegerList(String clock) {
    String[] clocks = clock.split(":");
    return Arrays.stream(clocks).map(Integer::parseInt).toArray(Integer[]::new);
  }

}
