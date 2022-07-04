package com.example.programmers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class s42579 {

  public static int[] solution(String[] genres, int[] plays) {
    int[] answer = {};
    HashMap<String, Integer> sum = new HashMap<>();
    for (int i = 0; i < genres.length; i++) {
      sum.put(genres[i], sum.getOrDefault(genres[i], 0) + plays[i]);
    }

    HashMap<String, Node> genreMap1 = new HashMap<>();
    HashMap<String, Node> genreMap2 = new HashMap<>();
    for (int i = 0; i < genres.length; i++) {
      if (!genreMap1.containsKey(genres[i])) { //처음 입력할 때
        genreMap1.put(genres[i], new Node(i, plays[i]));
      } else if (genreMap1.containsKey(genres[i])) { //제일 큰 값이 있을 때
        if (genreMap1.get(genres[i]).cost < plays[i]) { //가장 클 때 ->> 1칸 씩 밀림
          genreMap2.put(genres[i], genreMap1.get(genres[i]));
          genreMap1.put(genres[i], new Node(i, plays[i]));
        } else if (!genreMap2.containsKey(genres[i])) { //2번째 큰 값인지 확인
          genreMap2.put(genres[i], new Node(i, plays[i]));
        } else if (genreMap2.get(genres[i]).cost < plays[i]) {
          genreMap2.put(genres[i], new Node(i, plays[i]));
        }
      }
    }

    List<Map.Entry<String, Integer>> entryList = new LinkedList<>(sum.entrySet());
    entryList.sort((o1, o2) -> o2.getValue() - o1.getValue()); //value 내림차순 정렬

    answer = new int[genreMap1.size() + genreMap2.size()];
    int idx = 0;
    for (Map.Entry<String, Integer> entry : entryList) {
      answer[idx++] = genreMap1.get(entry.getKey()).index;
      if(genreMap2.containsKey(entry.getKey())){
        answer[idx++] = genreMap2.get(entry.getKey()).index;
      }
    }

    return answer;
  }

  private static class Node {

    int index;
    int cost;

    public Node(int index, int cost) {
      this.index = index;
      this.cost = cost;
    }
  }
}
