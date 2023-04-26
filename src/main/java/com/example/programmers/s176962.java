package com.example.programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class s176962 {

  public String[] solution(String[][] plans) {
    String[] answer = new String[plans.length];
    Plan[] planList = new Plan[plans.length];
    for (int i = 0; i < plans.length; i++) {
      String[] split = plans[i][1].split(":");
      planList[i] = new Plan(plans[i][0],
          Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]),
          Integer.parseInt(plans[i][2]));
    }
    Arrays.sort(planList, Comparator.comparingInt(o -> o.start));

    Stack<Plan> stack = new Stack<>();
    stack.add(planList[0]);
    int now = 1;
    int idx = 0;
    int nowTime = stack.peek().start;

    while (!stack.isEmpty()) {

      if (now == plans.length) { //모든 과제 진행중
        answer[idx++] = stack.pop().name;
      } else if (planList[now].start < nowTime + stack.peek().playtime) { //교체되는 경우
        int playtime = planList[now].start - nowTime; //이번 파트에서 진행한 시간
        stack.peek().playtime -= playtime;
        stack.add(planList[now++]);
        nowTime += playtime;
      } else { //이번에 종료됨
        Plan pop = stack.pop();
        nowTime += pop.playtime;
        answer[idx++] = pop.name;

        if (stack.isEmpty() || pop.start + pop.playtime == planList[now].start) {
          stack.add(planList[now++]);
          nowTime  = stack.peek().start;
        }
      }
    }

    return answer;
  }

  private class Plan {

    String name;
    int start;
    int playtime;

    public Plan(String name, int start, int playtime) {
      this.name = name;
      this.start = start;
      this.playtime = playtime;
    }
  }
}
