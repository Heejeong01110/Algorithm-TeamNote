package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class q20061 {

  private static int N;
  private static int[][] inp;

  private static int[][] shape = new int[][]{{0, 0}, {0, 0}, {0, 1}, {1, 0}};
  private static ArrayList<Deque<Integer>> green, blue;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    Solution();
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;
    N = Integer.parseInt(br.readLine());
    inp = new int[N][3];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      inp[i][0] = Integer.parseInt(st.nextToken());
      inp[i][1] = Integer.parseInt(st.nextToken());
      inp[i][2] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static void Solution() {
    green = new ArrayList<>();
    blue = new ArrayList<>();

    for (int i = 0; i < 4; i++) {
      green.add(new ArrayDeque<>());
      blue.add(new ArrayDeque<>());
    }

    int score = 0;
    int cnt = 0;
    //t x y
    for (int[] in : inp) {
      //1. 블록 위치 정보 구하기
      ArrayList<int[]> now = new ArrayList<>();
      now.add(new int[]{in[1], in[2]});
      if (in[0] != 1) {
        now.add(new int[]{in[1] + shape[in[0]][0], in[2] + shape[in[0]][0]});
      }

      //2. 그린, 블루 방향으로 블럭 넣기
      int greenMax = addBlock(green, now, true);
      int blueMax = addBlock(blue, now, false);

      //3. 한줄이 꽉 찬 경우 찾아서 없애기 -> score 한줄당 1점
      score += bingo(green, greenMax);
      score += bingo(blue, blueMax);

      //4. 오버된 경우 찾아서 지우기
      downBlock(green);
      downBlock(blue);

    }

    for (int i = 0; i < 4; i++) {
      while (!green.get(i).isEmpty()) {
        cnt += green.get(i).pollLast();
      }
      while (!blue.get(i).isEmpty()) {
        cnt += blue.get(i).pollLast();
      }
    }

    System.out.print(score + "\n");
    System.out.print(cnt);

  }

  private static void downBlock(ArrayList<Deque<Integer>> tile) {
    int delete = 0;
    for (int i = 0; i < 4; i++) {
      if (tile.get(i).size() > 4) {
        delete = tile.get(i).size() - 4;
      }
    }

    for (int i = 0; i < delete; i++) {
      for (int j = 0; j < 4; j++) {
        tile.get(j).pollLast();
      }
    }

  }

  private static int bingo(ArrayList<Deque<Integer>> tile, int max) {
    int score = 0;
    int[][] tmp = new int[4][6];

    for (int i = 0; i < max; i++) {
      int idx = 0;
      while (!tile.get(i).isEmpty()) {
        tmp[i][idx++] = tile.get(i).pollLast();
      }
    }

    // 빙고를 찾으면서 빈 부분에 0 넣어주기
    for (int i = 0; i < max; i++) {
      boolean bingo = true;
      for (int j = 0; j < 4; j++) {
        if (tmp[j][i] == 0) {
          bingo = false;
          break;
        }
      }

      if (bingo) {
        score += 1;
      } else {
        for (int j = 0; j < 4; j++) {
          tile.get(j).addFirst(tmp[j][i]);
        }
      }
    }
    return score;
  }

  private static int addBlock(ArrayList<Deque<Integer>> tile, ArrayList<int[]> now, boolean dir) {
    //dir 0 -> 그대로, 1 -> (x,y)좌표 바꿔서

    if (now.size() == 1) { // t == 1일때
      int r = dir ? now.get(0)[0] : now.get(0)[1];
      int c = dir ? now.get(0)[1] : now.get(0)[0];
      tile.get(c).addFirst(1);
      return tile.get(c).size();
    }

    //1자로 떨어질 때
    if (dir && now.get(0)[1] == now.get(1)[1] ||
        !dir && now.get(0)[0] == now.get(1)[0]) {
      int idx = dir ? now.get(0)[1] : now.get(0)[0];
      tile.get(idx).addFirst(1);
      tile.get(idx).addFirst(1);
      return tile.get(idx).size();
    }

    //ㅡ자로 떨어질때
    int max = 0;
    for (int i = 0; i < now.size(); i++) {
      int idx = dir ? now.get(i)[1] : now.get(i)[0];
      tile.get(idx).addFirst(1);
      max = Math.max(max, tile.get(idx).size());
    }
    return max;
  }

}
