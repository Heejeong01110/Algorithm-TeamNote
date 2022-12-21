package com.example.programmers;

public class s131703 {

  private static int answer;

  public static int solution(int[][] beginning, int[][] target) {
    answer = 11;
    int row = beginning.length;
    int col = beginning[0].length;
    int[][] map = new int[row][col];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        map[i][j] = beginning[i][j] == target[i][j] ? 0 : 1;
      }
    }

    int one = changeWhite(map, 0);
    int two = changeWhite(map, 1);

    if (one == -1 && two == -1) {
      return -1;
    } else if (one == -1) {
      return two;
    } else if (two == -1) {
      return one;
    }

    return Math.min(one, two);
  }

  private static int changeWhite(int[][] map, int color) {
    int answer = 0;
    int row = map.length;
    int col = map[0].length;

    int[][] clone = new int[row][col];
    for (int i = 0; i < row; i++) {
      clone[i] = map[i].clone();
    }

    for (int i = 0; i < col; i++) {
      if (clone[0][i] != color) {
        answer++;
        for (int j = 0; j < row; j++) {
          clone[j][i] = (clone[j][i] + 1) % 2;
        }
      }
    }

    for (int i = 0; i < row; i++) {
      if (clone[i][0] != color) {
        answer++;
        for (int j = 0; j < col; j++) {
          clone[i][j] = (clone[i][j] + 1) % 2;
        }
      }
    }

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (clone[i][j] != color) {
          return -1;
        }
      }
    }

    return answer;
  }

  int compare_colunm(int c, int[][] beginning, int[][] target, int n) {
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      if (beginning[i][c] == target[i][c]) {
        cnt++;
      }
    }

    if (cnt == 0) {
      return 1; //1) 해당 열(=c)에서 beginning과 target 전부 반대인 경우
    } else if (cnt == n) {
      return 0; //2) 해당 열(=c)에서 beginning과 target 전부 동일한 경우
    }
    return -1; //3) 1), 2)가 아닌 경우
  }

  private void dfs(int r, int c, int cnt, int n, int m, int[][] beginning, int[][] target) {
    //모든 행에서 뒤집거나 뒤집지 않는 선택을 완료한 경우
    if (r == n) {
      boolean flag = true;
      //열의 상태를 비교하여 TARGET과 동일하게 만들 수 있는지 판별
      for (int j = 0; j < m; j++) {
        int ret = compare_colunm(j, beginning, target, n);
        if (ret == -1) {
          flag = false;
          continue;
        } //현재 상태에서 TARGET과 동일하게 만들 수 없음 -> flag = 0;
        cnt += ret; //해당 열이 전부 반대인 경우 1이 반환되어 뒤집기 횟수가 1증가
      }
      if (flag) {
        answer = Math.min(answer, cnt); //TARGET과 동일하게 만들 수 있는 경우 최소 뒤집기 횟수 갱신
      }
    } else {
      dfs(r + 1, c, cnt, n, m, beginning, target); //해당 행 뒤집기 X
      flip_row(r, beginning, m);
      dfs(r + 1, c, cnt + 1, n, m, beginning, target); //해당 행 뒤집기
      flip_row(r, beginning, m);
    }
  }

  public void flip_row(int r, int[][] beginning, int m) {
    for (int j = 0; j < m; j++) {
      beginning[r][j] = (beginning[r][j] + 1) % 2;
    }
  }

}
