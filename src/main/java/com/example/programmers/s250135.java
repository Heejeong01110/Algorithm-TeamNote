package com.example.programmers;

public class s250135 {

  static int h, m, s;
  static int end;

  public static int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
    int answer = -1;

    end = toSec(h2, m2, s2);
    h = h1;
    m = m1;
    s = s1;

    while (true) {
      int now = toSec(h, m, s);
      if (now + 60 < end) {
        //1분 미만일 경우에 시간이 끝날 동안 분,시침과 만나는지 확인


        break;
      }

      //초침이 한바퀴 돌 동안 만나는 분,시침

      if (now == 0 || (now >= toSec(11, 0, 1) && now < toSec(12, 1, 0))) {
        //00시, 12시를 포함하는 구간일 경우
        answer += 1;
      } else {
        answer += 2;
      }

      plusMin();
    }

    return answer;
  }


  private static void plusMin() {
    m++;
    if (m == 60) {
      h++;
      m = 0;
    }
  }

  private static int toSec(int h, int m, int s) {
    return h * 3600 + m * 60 + s;
  }

  private static boolean lessThanMin(int h, int m, int s, int end) {
    return toSec(h, m, s) + 60 < end;
  }
}
