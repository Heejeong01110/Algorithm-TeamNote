package com.example.programmers;

public class s60059 {

  public static boolean solution(int[][] key, int[][] lock) {
    int point = key.length - 1;
    for(int x = 0; x < point + lock.length; x++) {
      for(int y = 0; y < point + lock.length; y++) {

        for(int r = 0; r < 4; r++) {
          int[][] newLock = new int[lock.length + key.length * 2][lock.length + key.length * 2];

          for(int i = 0; i < lock.length; i++) {
            for(int j = 0; j < lock.length; j++) {
              newLock[i + point][j + point] = lock[i][j]; //확장할 lock배열(arr) 초기화
            }
          }

          match(newLock, key, r, x, y);  //newLock배열에 key배열을 더해준다
          if(check(newLock, point, lock.length)) return true; //자물쇠 영역이 모두 유효한 값인지 확인
        }
      }
    }
    return false;
  }

  public static void match(int[][] newLock, int[][] key, int rot, int x, int y) {
    int len = key.length;
    for(int i = 0; i < len; i++) {
      for(int j = 0; j < len; j++) {
        if(rot == 0) { //한 번도 회전하지 않았을 때
          newLock[x + i][y + j] += key[i][j];
        } else if(rot == 1) { //시계방향으로 90도 회전한 경우
          newLock[x + i][y + j] += key[j][len - i - 1];
        } else if(rot == 2) { //180도 >회전<한 경우 (뒤집은 거랑은 다름)
          newLock[x + i][y + j] += key[len - i - 1][len- j - 1];
        } else { //270도 회전한 경우 == 반시계 방향으로 90도 회전한 경우
          newLock[x + i][y + j] += key[len - j - 1][i];
        }
      }
    }
  }

  public static boolean check(int[][] newLock, int point, int len) {
    for(int i = 0; i < len; i++) {
      for(int j = 0; j < len; j++) {
        if(newLock[point + i][point + j] != 1) return false;
      }
    }
    return true;
  }

}
