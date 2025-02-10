package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q20327 {

  private static int N, R, Len;
  private static int[][] map;
  private static int[][] commands;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    Solution();
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());
    Len = (int) Math.pow(2, N);
    map = new int[Len][Len];

    for (int i = 0; i < Len; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < Len; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    commands = new int[R][2];
    for (int i = 0; i < R; i++) {
      st = new StringTokenizer(br.readLine());
      commands[i][0] = Integer.parseInt(st.nextToken());
      commands[i][1] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static void Solution() {

    for (int[] command : commands) {
      //1. 배열을 부분배열로 나누기
      int pc = (int) (Math.pow(2, N) / Math.pow(2, command[1])); //한 줄당 부분배열의 갯수
      int pl = Len / pc;//부분 배열의 길이

      if (command[0] == 1) { //각 부분배열 상하반전
        for (int i = 0; i < pc; i++) {
          for (int j = 0; j < pc; j++) {
            changeUpDown(pl * i, pl * j, pl * (i + 1) - 1, pl * (j + 1) - 1);
          }
        }

      } else if (command[0] == 2) { //각 부분배열 좌우반전
        for (int i = 0; i < pc; i++) {
          for (int j = 0; j < pc; j++) {
            changeRightLeft(pl * i, pl * j, pl * (i + 1) - 1, pl * (j + 1) - 1);
          }
        }

      } else if (command[0] == 3) { //각 부분배열 오른쪽 90도 회전
        for (int i = 0; i < pc; i++) {
          for (int j = 0; j < pc; j++) {
            turnRight(pl * i, pl * j, pl * (i + 1) - 1, pl * (j + 1) - 1);
          }
        }

      } else if (command[0] == 4) { //각 부분배열 왼쪽 90도 회전
        for (int i = 0; i < pc; i++) {
          for (int j = 0; j < pc; j++) {
            turnLeft(pl * i, pl * j, pl * (i + 1) - 1, pl * (j + 1) - 1);
          }
        }

        //내부는 바뀌면 안됨.
      } else if (command[0] == 5) { //배열 상하반전
        changeUpDown(pc, pl);
      } else if (command[0] == 6) {//배열 좌우반전
        changeRightLeft(pc, pl);
      } else if (command[0] == 7) {//배열 오른쪽 90도 회전
        turnRight(pc, pl);
      } else if (command[0] == 8) {//배열 왼쪽 90도 회전
        turnLeft(pc, pl);
      }
    }

    for (int i = 0; i < Len; i++) {
      for (int j = 0; j < Len; j++) {
        System.out.print(map[i][j] + " ");
      }
      System.out.print("\n");
    }

  }


  private static void changeUpDown(int cnt, int len) {
    int sr, sc, er, tmp;
    for (int i = 0; i < cnt / 2; i++) {
      for (int j = 0; j < cnt; j++) {
        sr = len * i;
        sc = len * j;
        er = len * (cnt - i - 1);
        for (int r = 0; r < len; r++) {
          for (int c = 0; c < len; c++) {
            tmp = map[sr + r][sc + c];
            map[sr + r][sc + c] = map[er + r][sc + c];
            map[er + r][sc + c] = tmp;
          }
        }
      }
    }
  }

  private static void changeRightLeft(int cnt, int len) {
    int sr, sc, ec, tmp;
    for (int i = 0; i < cnt; i++) {
      for (int j = 0; j < cnt / 2; j++) {
        sr = len * i;
        sc = len * j;
        ec = len * (cnt - j - 1);
        for (int r = 0; r < len; r++) {
          for (int c = 0; c < len; c++) {
            tmp = map[sr + r][sc + c];
            map[sr + r][sc + c] = map[sr + r][ec + c];
            map[sr + r][ec + c] = tmp;
          }
        }
      }
    }
  }

  private static void turnRight(int cnt, int len) { //부분개열 갯수, 부분배열의 길이
    int xr, xc, yr, yc, tmp;
    for (int i = 0; i <= cnt / 2; i++) {
      for (int j = i; j < cnt - i - 1; j++) {
        xr = len * i;
        xc = len * j;
        yr = len * (cnt - i - 1);
        yc = len * (cnt - j - 1);
        for (int r = 0; r < len; r++) {
          for (int c = 0; c < len; c++) {
            tmp = map[xr + r][xc + c];
            map[xr + r][xc + c] = map[yc + r][xr + c];
            map[yc + r][xr + c] = map[yr + r][yc + c];
            map[yr + r][yc + c] = map[xc + r][yr + c];
            map[xc + r][yr + c] = tmp;
          }
        }
      }
    }
  }

  private static void turnLeft(int cnt, int len) {
    int xr, xc, yr, yc, tmp;
    for (int i = 0; i <= cnt / 2; i++) {
      for (int j = i; j < cnt - i - 1; j++) {
        xr = len * i;
        xc = len * j;
        yr = len * (cnt - i - 1);
        yc = len * (cnt - j - 1);
        for (int r = 0; r < len; r++) {
          for (int c = 0; c < len; c++) {
            tmp = map[xr + r][xc + c];
            map[xr + r][xc + c] = map[xc + r][yr + c];
            map[xc + r][yr + c] = map[yr + r][yc + c];
            map[yr + r][yc + c] = map[yc + r][xr + c];
            map[yc + r][xr + c] = tmp;
            tmp = map[xr + r][xc + c];
          }
        }
      }
    }
  }


  private static void changeUpDown(int sr, int sc, int er, int ec) {
    int tmp;
    int l = er - sr;
    for (int i = 0; i <= l / 2; i++) {
      for (int j = sc; j <= ec; j++) {
        tmp = map[sr + i][j];
        map[sr + i][j] = map[er - i][j];
        map[er - i][j] = tmp;
      }
    }
  }


  private static void changeRightLeft(int sr, int sc, int er, int ec) {
    int tmp;
    int l = er - sr;

    for (int i = sr; i <= er; i++) {
      for (int j = 0; j <= l / 2; j++) {
        tmp = map[i][sc + j];
        map[i][sc + j] = map[i][ec - j];
        map[i][ec - j] = tmp;
      }
    }
  }

  private static void turnRight(int sr, int sc, int er, int ec) {
    int tmp;
    int l = er - sr;
    for (int i = 0; i <= l / 2; i++) {
      for (int j = i; j < l - i; j++) {
        tmp = map[sr + i][sc + j];
        map[sr + i][sc + j] = map[er - j][sc + i];
        map[er - j][sc + i] = map[er - i][ec - j];
        map[er - i][ec - j] = map[sr + j][ec - i];
        map[sr + j][ec - i] = tmp;
      }
    }
  }

  private static void turnLeft(int sr, int sc, int er, int ec) {
    int tmp;
    int l = er - sr;
    for (int i = 0; i <= l / 2; i++) {
      for (int j = i; j < l - i; j++) {
        tmp = map[sr + i][sc + j];
        map[sr + i][sc + j] = map[sr + j][ec - i];
        map[sr + j][ec - i] = map[er - i][ec - j];
        map[er - i][ec - j] = map[er - j][sc + i];
        map[er - j][sc + i] = tmp;
      }
    }
  }

}
