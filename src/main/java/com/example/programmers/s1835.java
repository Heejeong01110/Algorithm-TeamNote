package com.example.programmers;

import java.util.ArrayList;

//단체사진 찍기
public class s1835 {

  private static int answer;
  private static String[] people = {"A", "C", "F", "J", "M", "N", "R", "T"};

  public static int solution(int n, String[] data) {
    answer = 0;
    ArrayList<String[]> map = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      String[] split1 = data[i].split("~");
      String one = split1[0];
      String two = split1[1].substring(0, 1);
      String bCase = split1[1].substring(1, 2);
      String between = split1[1].substring(2, 3);

      String[] ary = new String[]{one, two, bCase, between};
      map.add(ary);
    }

    dfs(0, new String[people.length], new boolean[people.length], map);

    return answer;
  }

  private static void dfs(int depth, String[] result, boolean[] visited, ArrayList<String[]> map) {
    if (depth == people.length) {
      //조건 일치하는지 판정
      if (matchMap(result, map)) {
        answer += 1;
      }
      return;
    }

    for (int i = 0; i < visited.length; i++) {
      if (!visited[i]) {
        result[depth] = people[i];
        visited[i] = true;
        dfs(depth + 1, result, visited, map);
        result[depth] = "";
        visited[i] = false;
      }
    }

  }

  private static boolean matchMap(String[] result, ArrayList<String[]> map) {
    for (int i = 0; i < map.size(); i++) {
      int indexOne = findIndex(map.get(i)[0], result);
      int indexTwo = findIndex(map.get(i)[1], result);
      int betweenLen = Math.abs(indexOne - indexTwo) - 1;
      int mapBetweenLen = Integer.parseInt(map.get(i)[3]);
      switch (map.get(i)[2]) {
        case "=":
          if (betweenLen != mapBetweenLen) {
            return false;
          }
          break;
        case "<":
          if (betweenLen >= mapBetweenLen) {
            return false;
          }
          break;
        case ">":
          if (betweenLen <= mapBetweenLen) {
            return false;
          }
          break;
        default:
          break;
      }
    }
    return true;
  }

  private static Integer findIndex(String find, String[] result) {
    for (int i = 0; i < result.length; i++) {
      if (result[i].equals(find)) {
        return i;
      }
    }
    return -1;
  }

}
