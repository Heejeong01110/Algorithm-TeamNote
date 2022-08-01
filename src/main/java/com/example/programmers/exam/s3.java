package com.example.programmers.exam;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class s3 {

  public static int solution(int[] order) {
    Queue<Integer> mainContainerBelt = new ArrayDeque<>();
    Stack<Integer> assistBelt = new Stack<>();
    for (int i = 1; i <= order.length; i++) {
      mainContainerBelt.add(i);
    }

    int nowIdx = 0;
    int[] actual = new int[order.length];
    while (!mainContainerBelt.isEmpty() || !assistBelt.isEmpty()) {
      if (!mainContainerBelt.isEmpty() && mainContainerBelt.peek() == order[nowIdx]) { //메인에 원하는 택배 있을 때
        actual[nowIdx++] = mainContainerBelt.poll();
      } else if (!assistBelt.isEmpty() && assistBelt.peek() == order[nowIdx]) { //보조에 있을 때
        actual[nowIdx++] = assistBelt.pop();
      } else if (!mainContainerBelt.isEmpty() && order[nowIdx] > mainContainerBelt.peek()) { //메인 라인 뒷쪽에 원하는 택배 있을 때
        assistBelt.add(mainContainerBelt.poll());
      } else { //더이상 담을 수 없을 때
        break;
      }
    }

    return nowIdx;
  }
}
