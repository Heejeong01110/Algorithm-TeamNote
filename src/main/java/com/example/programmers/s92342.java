package com.example.programmers;

//양궁대회
public class s92342 {

  private static Integer maxScoreRange;
  private static int[] scoreNote;

  public static int[] solution(int n, int[] info) {
    maxScoreRange = 0;
    scoreNote = new int[info.length];

    comb2(new int[info.length], 0, 0, n, info);

    if (maxScoreRange == 0) {
      scoreNote = new int[]{-1};
    }

    return scoreNote;
  }


  // 서로 다른 n개에서 순서 없이, 중복이 가능하게 r개를 뽑는 경우의 수
  private static void comb2(int[] visited, int start, int depth, int r, int[] info) {
    if (depth == r) {
      int scoreLion = 0;
      int scoreApc = 0;

      for (int i = 0; i <= 10; i++) {
        if (visited[10 - i] > info[10 - i]) {
          scoreLion += i;
        } else if (info[10 - i] > 0) {
          scoreApc += i;
        }
      }

      //높은 점수가 아니라 점수차가 중요
      if (scoreLion > scoreApc && (scoreLion - scoreApc) > maxScoreRange) {
        maxScoreRange = scoreLion - scoreApc;
        scoreNote = visited.clone();
      }
      return;
    }

    for (int i = start; i <= 10; i++) {
      visited[10 - i] += 1;
      comb2(visited, i, depth + 1, r, info);
      visited[10 - i] -= 1;
    }
  }


}
