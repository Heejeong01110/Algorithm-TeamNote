package com.example.programmers;

import java.util.ArrayList;
import java.util.List;

public class s150366 {

  public static int[] parent = new int[2501];
  public static String[] note = new String[2501];

  public static String[] solution(String[] commands) {
    List<String> result = new ArrayList<>();
    for (int i = 1; i < 2501; i++) {
      parent[i] = i;
      note[i] = "";
    }

    for (String command : commands) {
      String[] split = command.split(" ");
      switch (split[0]) {
        case "UPDATE" -> {
          if (split.length == 4) { //UPDATE 4 3 noodle
            int row = Integer.parseInt(split[1]);
            int col = Integer.parseInt(split[2]);
            String value = split[3];

            int num = convertNum(row, col);
            note[num] = value;

          } else { //UPDATE value1 value2 -> value1을 값으로 가지고 있는 모든 셀을 value2로 바꾸기
            String value1 = split[1];
            String value2 = split[2];

            for (int i = 1; i < 2501; i++) {
              if (value1.equals(note[i])) {
                note[i] = value2;
              }
            }
          }

        }
        case "MERGE" -> { //MERGE r1 c1 r2 c2 (두 좌표 값이 같음)
          int r1 = Integer.parseInt(split[1]);
          int c1 = Integer.parseInt(split[2]);
          int r2 = Integer.parseInt(split[3]);
          int c2 = Integer.parseInt(split[4]);

          int n1 = convertNum(r1, c1);
          int n2 = convertNum(r2, c2);

          int root1 = find(n1);
          int root2 = find(n2);

          if (root1 == root2) {
            continue;
          }

          //value값 가져오기
          String rootString = note[root1].isBlank() ? note[root2] : note[root1];

          note[root1] = "";
          note[root2] = "";
          union(root1, root2);
          note[root1] = rootString;

        }
        case "UNMERGE" -> { //UNMERGE r c -> 셀 병합 해제 후 해당 값은 (r,c)가 가짐
          int row = Integer.parseInt(split[1]);
          int col = Integer.parseInt(split[2]);

          int num = convertNum(row, col);
          int root = find(num);
          String rootString = note[root];
          note[root] = "";
          note[num] = rootString;

          List<Integer> deleteList = new ArrayList<>();
          for (int i = 1; i < 2501; i++) {
            if (find(i) == root) {
              deleteList.add(i);
            }
          }

          for (Integer t : deleteList) {
            parent[t] = t;
          }

        }
        case "PRINT" -> { //PRINT r c
          int row = Integer.parseInt(split[1]);
          int col = Integer.parseInt(split[2]);

          int num = convertNum(row, col);
          int root = find(num);
          if (note[root].isBlank()) {
            result.add("EMPTY");
          } else {
            result.add(note[root]);
          }

        }
      }
    }

    return result.toArray(new String[0]);
  }


  private static int find(int x) {
    if (x == parent[x]) {
      return x;
    } else {
      return parent[x] = find(parent[x]);
    }
  }

  private static void union(int x, int y) {
    x = find(x);
    y = find(y); // 같은 부모를 가지고 있지 않을 때
    if (x != y) { // y가 x 보다 크다는 것을 가정한다면 아래와 같이 표현
      parent[y] = x;
    }
  }

  public static int convertNum(int x, int y) {
    int result = 50 * (x - 1);
    return result + y;
  }

}
