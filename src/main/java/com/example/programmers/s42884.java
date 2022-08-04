package com.example.programmers;

import java.util.Arrays;

public class s42884 {

  public static int solution(int[][] routes) {
    Arrays.sort(routes, (o1, o2) -> {
      if (o1[1] == o2[1]) {
        return o1[0] - o2[0];
      }
      return o1[1] - o2[1];
    });

    int lastCamera = -30000;
    int answer = 0;

    for (int i = 0; i < routes.length; i++) {
      if (lastCamera < routes[i][0]) {
        lastCamera = routes[i][1];
        answer++;
      }
    }

    return answer;
  }

}
