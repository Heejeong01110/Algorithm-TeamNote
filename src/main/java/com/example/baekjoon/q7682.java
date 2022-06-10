package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q7682 {

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    String str = br.readLine();
    int[][] map;
    int countX;
    int countO;
    while (!str.equals("end")) {
      map = new int[3][3];
      countX = 0;
      countO = 0;

      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          char ch = str.charAt(i * 3 + j);
          map[i][j] = (ch == 'X' ? -1 : (ch == 'O' ? 1 : 0));
          if (map[i][j] > 0) {
            countO++;
          } else if (map[i][j] < 0) {
            countX++;
          }
        }
      }

      if (countO != countX && countO + 1 != countX) {
        sb.append("invalid\n");
        str = br.readLine();
        continue;
      }

      boolean xBingo = isBingo(map, "X");
      boolean oBingo = isBingo(map, "O");

      if(countO+ countX == 9){
        if(!oBingo){
          sb.append("valid\n");
        }else{
          sb.append("invalid\n");
        }
      }else if (countO == countX) { // O 빙고
        if (!xBingo && oBingo) {
          sb.append("valid\n");
        } else {
          sb.append("invalid\n");
        }
      } else if (countO + 1 == countX) { // X 빙고
        if (xBingo && !oBingo) {
          sb.append("valid\n");
        } else {
          sb.append("invalid\n");
        }
      }

      str = br.readLine();
    }

    System.out.print(sb.toString());
    br.close();
  }

  private static boolean isBingo(int[][] map, String type) {
    int x = type.equals("X") ? -3 : 3;
    boolean bingo = false;
    int bingoCount = 0;

    if (map[0][0] + map[1][1] + map[2][2] == x) {
      bingo = true;
      bingoCount++;
      map[0][0] = map[1][1] = map[2][2] = 0;
    }

    if (map[0][2] + map[1][1] + map[2][0] == x) {
      bingo = true;
      bingoCount++;
      map[0][2] = map[1][1] = map[2][0] = 0;
    }

    for (int i = 0; i < 3; i++) {
      if (map[i][0] + map[i][1] + map[i][2] == x) {
        bingo = true;
        bingoCount++;
        map[i][0] = map[i][1] = map[i][2] = 0;
      }
      if (map[0][i] + map[1][i] + map[2][i] == x) {
        bingo = true;
        bingoCount++;
        map[0][i] = map[1][i] = map[2][i] = 0;
      }
    }

    if (!bingo) {
      return false;
    }
    return bingoCount == 1;
  }

}
