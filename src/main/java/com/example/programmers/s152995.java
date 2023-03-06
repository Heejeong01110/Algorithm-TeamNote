package com.example.programmers;

import java.util.Arrays;

public class s152995 {

  public int solution(int[][] scores) {
    int answer = 0;

    // 원호의 점수 저장
    int[] wonho = scores[0];

    // 근무 태도 점수 오름차순 정렬 (같으면 동료평가 점수 내림차순)
    Arrays.sort(scores, (o1, o2) -> {
      if (o1[0] == o2[0]) {
        return o1[1] - o2[1];
      }
      return o2[0] - o1[0];
    });

    // 동료평가 점수 저장
    int maxB = Integer.MIN_VALUE;
    for (int[] score : scores) {
      boolean isDrop = false;

      if (maxB < score[1]) {
        maxB = score[1];
      }
      // 동료 평가 점수가 더 낮으면 drop
      else if (maxB > score[1]) {
        isDrop = true;
      }

      if (isDrop) {
        //대상이 원호거나 원호랑 같은 점수라면 -1
        if (score[0] == wonho[0] && score[1] == wonho[1]) {
          return -1;
        }
        // 아니면 다음 반복문 수행
        continue;
      }

      // 원호보다 등수가 높은 사람 수만 카운트
      if (score[0] + score[1] > wonho[0] + wonho[1]) {
        answer++;
      }
    }

    return answer + 1;
  }
}
