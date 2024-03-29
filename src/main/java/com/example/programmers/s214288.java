package com.example.programmers;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class s214288 {
  private ArrayList<User>[] users;
  private int P, K, N, answer;
  int[][] mentors;


  public int solution(int k, int n, int[][] reqs) {
    answer = Integer.MAX_VALUE;
    P = reqs.length;
    K = k;
    N = n;
    users = new ArrayList[K + 1];
    mentors = new int[K + 1][P + 1];

    for (int i = 1; i <= K; i++) {
      users[i] = new ArrayList<>();
    }
    for (int[] req : reqs) {
      users[req[2]].add(new User(req[2], req[0], req[0] + req[1]));
    }
    for (int i = 1; i <= K; i++) {
      users[i].sort((o1, o2) -> o1.start == o2.start ? o1.end - o2.end : o1.start - o2.start);
    }

    int usedMentor, delaySum;
    PriorityQueue<User> queue;

    for (int t = 1; t <= K; t++) {// t타입인 참가자 체크
      int size = users[t].size();
      for (int s = 1; s < size; s++) { //멘토가 s명일 경우 대기시간 구하기
        queue = new PriorityQueue<>((o1, o2) -> o1.end - o2.end);
        usedMentor = 0;
        delaySum = 0;

        for (int i = 0; i < size; i++) {
          User user = users[t].get(i);

          while (!queue.isEmpty()) {
            if (queue.peek().end > user.start) {
              break;
            }
            usedMentor -= 1;
            queue.poll();
          }

          if (s - usedMentor > 0) { //1. 상담 중이 아닌 멘토가 있을 때
            usedMentor += 1;
            queue.add(user);
          } else { //2. 모두 상담중일 경우
            int delayTime = queue.poll().end - user.start;
            delaySum += delayTime;
            User delayUser = new User(user.type, user.start + delayTime, user.end + delayTime);
            queue.add(delayUser);
          }
        }
        mentors[t][s] = delaySum;
      }
    }

    dfs(new int[K + 1], N, 1);
    return answer;
  }

  private void dfs(int[] result, int remain, int idx) {
    if (idx == K) {
      result[idx] = remain;
      int sum = 0;
      for (int i = 1; i <= K; i++) {
        sum += mentors[i][result[i]];
      }
      answer = Math.min(answer, sum);
      return;
    }
    for (int i = 1; i <= remain - (K - idx); i++) {
      result[idx] = i;
      dfs(result, remain - result[idx], idx + 1);
    }
  }

  private class User {

    int type;
    int start;
    int end;

    public User(int type, int start, int end) {
      this.type = type;
      this.start = start;
      this.end = end;
    }
  }
}
