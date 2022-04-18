package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class q12100 {

  private static final int[][] direct = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
  private static int N;
  private static int[][] map;
  private static int result;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    output(Solution());
  }

  private static void output(int result) {
    System.out.print(result);
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    map = new int[N][N];

    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    br.close();
  }

  private static int Solution() {
    result = 0;
    perm(new int[5], 0);
    return result;
  }

  // 서로 다른 n개에서 중복이 가능하게 r개를 뽑아서 정렬하는 경우의 수
  private static void perm(int[] out, int depth) {
    if (depth == 5) {
      int[][] cloneM = new int[N][N];
      for (int i = 0; i < N; i++) {
        cloneM[i] = map[i].clone();
      }
      simulation(cloneM, 0, out);
      return;
    }
    for (int i = 0; i < 4; i++) {
      out[depth] = i;
      perm(out, depth + 1);
    }
  }

  private static void simulation(int[][] mMap, int depth, int[] dirList) {
    if (depth == 5) {
      int maxValue = 0;
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          maxValue = Math.max(maxValue, mMap[i][j]);
        }
      }

      result = Math.max(maxValue, result);
      return;
    }

    Stack<Integer> stack;
    switch (dirList[depth]) {
      case 0: //왼쪽으로
        for (int i = 0; i < N; i++) {
          stack = new Stack<>();
          boolean check = false;
          for (int j = 0; j < N; j++) {
            if (mMap[i][j] == 0) {
              continue;
            }
            if (stack.isEmpty()) {
              stack.add(mMap[i][j]);
              check = false;
            } else if (stack.peek() == mMap[i][j] && !check) {
              stack.pop();
              stack.add(mMap[i][j] * 2);
              check = true;
            } else {
              stack.add(mMap[i][j]);
              check = false;
            }
          }

          int size = stack.size();
          for (int j = size - 1; j >= 0; j--) {
            mMap[i][j] = stack.pop();
          }
          for (int j = size; j < N; j++) {
            mMap[i][j] = 0;
          }

        }
        break;
      case 1: //오른쪽으로
        for (int i = 0; i < N; i++) {
          stack = new Stack<>();
          boolean check = false;
          for (int j = N - 1; j >= 0; j--) {
            if (mMap[i][j] == 0) {
              continue;
            }
            if (stack.isEmpty()) {
              stack.add(mMap[i][j]);
              check = false;
            } else if (stack.peek() == mMap[i][j] && !check) {
              stack.pop();
              stack.add(mMap[i][j] * 2);
              check = true;
            } else {
              stack.add(mMap[i][j]);
              check = false;
            }
          }

          int size = stack.size();
          for (int j = N - size; j < N; j++) {
            mMap[i][j] = stack.pop();
          }
          for (int j = N - 1 - size; j >= 0; j--) {
            mMap[i][j] = 0;
          }

        }
        break;
      case 2: //위쪽으로
        for (int j = 0; j < N; j++) {
          stack = new Stack<>();
          boolean check = false;
          for (int i = 0; i < N; i++) {
            if (mMap[i][j] == 0) {
              continue;
            }
            if (stack.isEmpty()) {
              stack.add(mMap[i][j]);
              check = false;
            } else if (stack.peek() == mMap[i][j] && !check) {
              stack.pop();
              stack.add(mMap[i][j] * 2);
              check = true;
            } else {
              stack.add(mMap[i][j]);
              check = false;
            }
          }
          int size = stack.size();
          for (int i = size - 1; i >= 0; i--) {
            mMap[i][j] = stack.pop();
          }
          for (int i = size; i < N; i++) {
            mMap[i][j] = 0;
          }
        }
        break;
      case 3: //아랫쪽으로
        for (int j = 0; j < N; j++) {
          stack = new Stack<>();
          boolean check = false;
          for (int i = N - 1; i >= 0; i--) {
            if (mMap[i][j] == 0) {
              continue;
            }
            if (stack.isEmpty()) {
              stack.add(mMap[i][j]);
              check = false;
            } else if (stack.peek() == mMap[i][j] && !check) {
              stack.pop();
              stack.add(mMap[i][j] * 2);
              check = true;
            } else {
              stack.add(mMap[i][j]);
              check = false;
            }
          }

          int size = N - stack.size();

          for (int i = size; i < N; i++) {
            mMap[i][j] = stack.pop();
          }
          for (int i = size - 1; i >= 0; i--) {
            mMap[i][j] = 0;
          }

        }
        break;
      default:
        break;
    }

    simulation(mMap, depth + 1, dirList);
  }

}
