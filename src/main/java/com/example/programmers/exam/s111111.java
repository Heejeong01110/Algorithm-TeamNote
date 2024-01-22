package com.example.programmers.exam;

import java.util.Arrays;

public class s111111 {

  static int ans;
  static int[] Dots;
  static int[] Lines;

  //dots 20개 lines 10개
  public static int solution(int[] dots, int[] lines) {
    ans = dots.length + 1;
    Dots = dots.clone();
    Lines = lines.clone();

    Arrays.sort(Lines);

    dfs(0, 0, new boolean[lines.length]);
    return ans;
  }

  private static void dfs(int now_dot, int line_cnt, boolean[] lines_vis) {
    if(ans <= line_cnt){
      return;
    }

    if(now_dot >= Dots.length){
      ans = line_cnt;
    }

    //1. now_dot에 모든 선분을 차례대로 놓기
    for (int i = 0; i < Lines.length; i++) {
      if (lines_vis[i]) { //line 중복사용 X
        continue;
      }

      int last_dot = now_dot;
      //2. line에 의해 체크되는 점 목록 확인
      for (int d = now_dot; d < Dots.length; d++) {
        //선분 위에 있는 점인지 확인
        if (Dots[d] > Dots[now_dot] + Lines[i]) {
          break;
        }
        last_dot = d;
      }

      //3. 다음 점으로 이동
      lines_vis[i] = true;
      dfs(last_dot + 1, line_cnt + 1, lines_vis);
      lines_vis[i] = false;
    }
  }


}
