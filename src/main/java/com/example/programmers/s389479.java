package com.example.programmers;

import java.util.ArrayDeque;
import java.util.Queue;

public class s389479 {
  public static int solution(int[] players, int m, int k) {
    int answer = 0;
    int active=0;
    int[] install = new int[players.length];

    for(int i = 0;i<players.length;i++){
      if(i >= k){
        active -= install[i-k];
      }
      int need = players[i] / m;
      if(need > active){
        int add = need - active;
        active += add;
        install[i] = add;
        answer += add;
      }
    }
    return answer;
  }
}
