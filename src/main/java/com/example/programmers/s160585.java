package com.example.programmers;

public class s160585 {

  //1. O가 선공 --> O의 갯수 >= X의 갯수
  //2. 빙고가 없을 경우
  //   흰색갯수 = 검정갯수+1  or  흰색갯수 = 검정갯수
  //3. 빙고가 있을 경우
  //   3-1. 흰색 빙고 -> 흰색갯수 = 검정갯수 + 1
  //   3-2. 검정 빙고 -> 흰색갯수 = 검정갯수
  public static int solution(String[] board) {
    int[][] map = new int[3][3];
    int whiteCnt = 0;
    int blackCnt = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        char item = board[i].charAt(j);
        if (item == 'O') {
          map[i][j] = 1;
          whiteCnt++;
        } else if (item == 'X') {
          map[i][j] = -1;
          blackCnt++;
        } else {
          map[i][j] = 0;
        }
      }
    }

    if (!(whiteCnt == blackCnt || whiteCnt == blackCnt + 1)) {
      return 0;
    }

    int whiteBingo = getBingoCnt(map, 1);
    int blackBingo = getBingoCnt(map, -1);

    if (whiteBingo > 0 && blackBingo > 0) {
      return 0;
    }

    if (whiteBingo == 0 && blackBingo == 0) {
      return 1;
    }

    if (whiteBingo > 0 && whiteCnt == blackCnt + 1 || blackBingo > 0 && whiteCnt == blackCnt) {
      return 1;
    }
    return 0;
  }

  private static int getBingoCnt(int[][] map, int color) {
    int cnt = 0;
    for (int i = 0; i < 3; i++) {
      if (map[i][0] == color && map[i][1] == color && map[i][2] == color) {
        cnt++;
      }
      if (map[0][i] == color && map[1][i] == color && map[2][i] == color) {
        cnt++;
      }
    }
    if (map[0][0] == color && map[1][1] == color && map[2][2] == color) {
      cnt++;
    }
    if (map[0][2] == color && map[1][1] == color && map[2][0] == color) {
      cnt++;
    }
    return cnt;
  }

}
