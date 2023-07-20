package com.example.programmers;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class s214288 {

  private ArrayList<User> users;
  private int P, K, N;
  private int result;


  public int solution(int k, int n, int[][] reqs) {
    result = Integer.MAX_VALUE;
    P = reqs.length;
    K = k;
    N = n;
    users = new ArrayList<>();
    for (int[] req : reqs) {
      users.add(new User(req[2], req[0], req[0] + req[1]));
    }
    users.sort((o1, o2) -> o1.start == o2.start ? o1.end - o2.end : o1.start - o2.start);
    int[] types = new int[K + 1];
    for (int i = 1; i <= K; i++) {
      types[i] = 1;
    }

    dfs(types, new int[K + 1], 0, k, 0, new PriorityQueue<>((o1, o2) -> o1.end - o2.end));

    return result;
  }

  private void dfs(int[] types, int[] usedTypes, int delaySum, int typeSum, int now,
      PriorityQueue<User> preQueue) {
    if (delaySum >= result) {
      return;
    }

    if (now == P) {
      result = Math.min(result, delaySum);
      return;
    }

    //1. now의 시작시간 전에 끝나는 queue내용 다 꺼내기
    User user = users.get(now);
    int nowStartTime = user.start;
    PriorityQueue<User> queue = new PriorityQueue<>(preQueue);
    while (!queue.isEmpty()) {
      if (queue.peek().end > nowStartTime) {
        break;
      }
      usedTypes[queue.peek().type] -= 1;
      queue.poll();
    }

    //2. now를 상담하는경우, 대기했다가 하는 경우
    if (types[user.type] - usedTypes[user.type] > 0) {//2-1. 쉬는시간인 type멘토가 있을 경우 --> 즉시 배정
      usedTypes[user.type] += 1;
      queue.add(user);
      dfs(types.clone(), usedTypes.clone(), delaySum, typeSum, now + 1, queue);
      usedTypes[user.type] -= 1;
      queue.remove(user);
    } else {// 2-2. 쉬는시간인 type멘토가 없을 경우 --> 새로배정, 대기 후 배정
      //1. 새로 배정
      if (typeSum < N) {//새로 타입 지정 가능한 경우만
        types[user.type] += 1;
        typeSum += 1;
        usedTypes[user.type] += 1;
        queue.add(user);
        dfs(types.clone(), usedTypes.clone(), delaySum, typeSum, now + 1, queue);
        types[user.type] -= 1;
        typeSum -= 1;
        usedTypes[user.type] -= 1;
        queue.remove(user);
      }else{ //모두 상담중인 경우만 --> 딜레이
        int delayTime = getDelay(user, queue); //1. 딜레이 시간 구하기
        User delayUser = new User(user.type, user.start + delayTime, user.end + delayTime);
        queue.add(delayUser);
        dfs(types.clone(), usedTypes.clone(), delaySum + delayTime, typeSum, now + 1, queue);
        queue.remove(delayUser);
      }
    }
  }

  private int getDelay(User user, PriorityQueue<User> preQueue) { //해당 유저의 delay시간 구하기
    PriorityQueue<User> queue = new PriorityQueue<>(preQueue);
    while (!queue.isEmpty()) {
      if (queue.peek().type == user.type) {
        preQueue.remove(queue.peek());
        return queue.peek().end - user.start;
      }
      queue.poll();
    }
    return -1;
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
