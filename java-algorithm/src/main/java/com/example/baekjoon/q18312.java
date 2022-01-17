package com.example.baekjoon;

import java.io.*;
import java.util.*;

public class q18312 {

  private static Integer K;
  private static Integer N;
  private static HashMap<Integer, Integer> minMap = new HashMap<>();

  public static void main(String[] args) throws IOException {
    inputData();
    getCount();
    print(Solution());
  }

  private static int Solution() {
    Integer result = 0;

    for(int i=0;i<=N;i++){
      if((i/10)==K || (i%10)==K){
        result += 60 * 60;
      }else{
        result += minMap.get(-1);
      }
    }

    return result;
  }

  private static void print(int result){
    System.out.println(result);
  }

  private static void getCount() {
    Integer resultMin, resultSec;

    for(int i=0;i<60;i++){
      resultMin = 0;
      resultSec = 0;
      if((i/10)==K || (i%10)==K){
        resultMin += 60;
        minMap.put(i, resultMin);
        continue;
      }

      for(int j=0;j<60;j++){
        if((j/10)==K || (j%10)==K){
          resultSec += 1;
        }
      }

      resultMin += resultSec;
      minMap.put(i, resultMin);
    }

    for(int i=0;i<60;i++){
      minMap.put(-1, minMap.getOrDefault(-1, 0) + minMap.get(i));
    }
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    br.close();
  }

}
