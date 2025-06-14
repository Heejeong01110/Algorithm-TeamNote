package com.example.programmers;

import java.util.ArrayDeque;
import java.util.Queue;

public class s389479 {
  public static int solution(int[] players, int m, int k) {
    int answer = 0;
    int size = 0;
    Queue<Integer> server = new ArrayDeque<>();
    for(int player : players){
      //1. 종료된 서버 정리
      size = server.size();
      for(int i = 0; i < size; i++){
        if(server.peek() == 1){
          server.poll();
        }else{
          server.add(server.poll() - 1);
        }
      }

      int need = player / m;

      //2. 서버 추가로 필요한 만큼 증설
      if(need > server.size()){
        size = server.size();
        for(int i = 0;i<need- size;i++){
          server.add(k);
          answer++;
        }
      }
    }

    return answer;
  }
}
