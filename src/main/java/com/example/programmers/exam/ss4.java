package com.example.programmers.exam;

import java.util.ArrayList;
import java.util.Stack;

public class ss4 {

  public static String[] solution(int maxSize, String[] actions) {
    String[] answer = {};
    Stack<String> back = new Stack<>();
    Stack<String> front = new Stack<>();
    ArrayList<String> list = new ArrayList<>();
    String now = "";

    for (int i = 0; i < actions.length; i++) {
      String action = actions[i];
      if (now.equals("")) {
        if (!action.equals("B") && !action.equals("F")) {
          now = action;
          list.add(now);
        }
        continue;
      }

      if (action.equals("B")) {
        if (!back.isEmpty()) {
          front.add(now);
          String pop = back.pop();
          now = pop;

          if (list.contains(pop)) {
            list.remove(pop);
          }
          list.add(pop);
        }


      } else if (action.equals("F")) {
        if (!front.isEmpty()) {
          back.add(now);
          String pop = front.pop();
          now = pop;

          if (list.contains(pop)) {
            list.remove(pop);
          }
          list.add(pop);
        }


      } else {
        back.add(now);
        front.clear();
        now = action;
        if (list.contains(action)) {
          list.remove(action);
        }
        list.add(action);

      }
    }

    int size = Math.min(list.size(), maxSize);
    answer = new String[size];
    for (int i = 0; i < size; i++) {
      answer[i] = list.get(list.size() - i - 1);
    }

    return answer;
  }
}
