package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class q3678 {

  private static int[][] map;
  private static int[] dp;
  private static int[] curSum;
  private static int[][] counts;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer T = Integer.parseInt(br.readLine());
    map = new int[60][1000]; //현재 위치의 자원 정보
    // [0] : 몇겹의 나선인지 [1] : 나선 내부의 순서
    dp = new int[20000];
    curSum = setCur();
    map[0][0] = 1;
    dp[1] = 1;
    map[1][0] = 2;
    dp[2] = 2;
    map[1][1] = 3;
    dp[3] = 3;
    map[1][2] = 4;
    dp[4] = 4;
    map[1][3] = 5;
    dp[5] = 5;
    map[1][4] = 2;
    dp[6] = 2;
    map[1][5] = 3;
    dp[7] = 3;

    counts = new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 2}, {4, 1}, {5, 1}};

    //map 정보
    /*
    0 -> 1개의 점                -> 누적 1개        1개
    1 -> 한변이 1인 6각형         -> 누적 1+6개      7개
    2 -> 한변이 2인 6각형         -> 누적 1+6+12개   19개
     */

    int maxCur = 1;
    for (int t = 0; t < T; t++) {
      Integer N = Integer.parseInt(br.readLine());
      maxCur = dfs(maxCur, N);
      System.out.print(dp[N] + "\n");
    }

  }

  private static Integer dfs(int maxCur, int target) {
    if (curSum[maxCur] >= target) {
      return maxCur;
    }

    //1. 몇겹 째의 수인지 확인
    int cur = getCur(target);
    int idx = curSum[maxCur] + 1;
    for (int i = maxCur + 1; i <= cur; i++) {
      int len = i * 6;
      for (int j = 0; j < len; j++) {
        //2. map[i][j] 위치의 자원 구하기
        //start 위치 구하기;
        int sj = ((len - (i - 1)) + j) % len;
        boolean[] visited = getVisited(i, sj, len);
        //2-1. 보드에 가장 적게 나타난 자원 순으로 정렬
        Arrays.sort(counts, ((o1, o2) -> {
          if (o1[1] == o2[1]) {
            return o1[0] - o2[0];
          }
          return o1[1] - o2[1];
        }));
        for (int k = 0; k <= 5; k++) {
          if (counts[k][0] == 0) {
            continue;
          }
          if (!visited[counts[k][0]]) {
            map[i][sj] = counts[k][0];
            dp[idx++] = counts[k][0];
            counts[k][1] += 1;
            break;
          }
        }
      }
    }

    return cur;
  }

  private static boolean[] getVisited(int i, int j, int len) {
    boolean[] visited = new boolean[6];
    //1. 좌우의 노드 확인
    if (j == 0) {
      visited[map[i][j + 1]] = true;
      visited[map[i][len - 1]] = true;
    } else if (j == len - 1) {
      visited[map[i][j - 1]] = true;
      visited[map[i][0]] = true;
    } else {
      visited[map[i][j - 1]] = true;
      visited[map[i][j + 1]] = true;
    }

    //2. 이전 겹 확인
    if (j % i == 0) { // 꼭짓점일 경우 : 확인할 노드 1개
      visited[map[i - 1][(j / i) * (i - 1)]] = true;
    } else { //확인할 노드 2개
      int idx = ((j / i) * (i - 1) + (j % i));
      visited[map[i - 1][idx % ((i - 1) * 6)]] = true;
      visited[map[i - 1][(idx - 1) % ((i - 1) * 6)]] = true;
    }

    return visited;
  }

  private static int[] setCur() {
    int[] curSum = new int[60];
    int num = 0;
    curSum[0] = 1;
    while (curSum[num] <= 10000) {
      num++;
      curSum[num] = curSum[num - 1] + 6 * num;
    }
    curSum[num] = curSum[num - 1] + 6 * num;
    return curSum;
  }

  private static Integer getCur(int num) {
    for (int i = 0; i < curSum.length; i++) {
      if (num < curSum[i]) {
        return i;
      }
    }
    return -1;
  }


}
