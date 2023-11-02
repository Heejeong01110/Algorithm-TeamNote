package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class q1132 {

  private static int N;
  private static String[] inp;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    System.out.print(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    inp = new String[N];

    for (int i = 0; i < N; i++) {
      inp[i] = br.readLine();
    }

    br.close();
  }

  private static long Solution() {
    Node[] alp = new Node[10];
    for (int i = 0; i < 10; i++) {
      alp[i] = new Node(0, false);
    }
    for (int i = 0; i < N; i++) {
      char[] ch = inp[i].toCharArray();

      for (int j = 0; j < ch.length; j++) {
        int idx = ch[j] - 'A';
        long num = (long) Math.pow(10, ch.length - j - 1);
        alp[idx].num += num;
        if (j == 0) {
          alp[idx].front = true;
        }
      }
    }

    Arrays.sort(alp, ((o1, o2) -> {
      if (o1.num == o2.num) {
        if (o1.front && o2.front || !o1.front && !o2.front) {
          return 0;
        }
        return o1.front ? 1 : -1;
      }
      return Long.compare(o1.num, o2.num);
    }));

    Node[] result = new Node[10];
    boolean tmp = true;
    int idx = 0;
    int frontIdx = 0;
    for (int i = 0; i < 10; i++) {
      if (tmp) { //front가 0이 될 확률이 있는 상태
        if (alp[i].front) { //0이 되는 경우
          frontIdx++;
          result[frontIdx] = alp[i];
        } else {
          result[idx++] = alp[i];
          tmp = false;
        }
      } else {
        result[frontIdx + idx] = alp[i];
        idx++;
      }
    }

    long answer = 0;
    for (int i = 0; i < 10; i++) {
      answer += result[i].num * i;
    }
    return answer;
  }

  private static class Node {

    long num;
    boolean front;

    public Node(long num, boolean front) {
      this.num = num;
      this.front = front;
    }
  }

}
