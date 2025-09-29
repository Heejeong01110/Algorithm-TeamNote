package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class q2161 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    Deque<Integer> queue = new ArrayDeque<>();
    for (int i = 1; i <= N; i++) {
      queue.addLast(i);
    }
    int count = 1;
    while (!queue.isEmpty()) {
      if (count % 2 == 1) {
        bw.write(queue.pollFirst() + " ");
      } else {
        int temp = queue.pollFirst();
        queue.addLast(temp);
      }
      count++;
    }
    bw.flush();    //결과 출력
    bw.close();
    br.close();
  }
}
