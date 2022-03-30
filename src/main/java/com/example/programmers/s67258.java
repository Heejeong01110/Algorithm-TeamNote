package com.example.programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class s67258 {

  public static int[] solution(String[] gems) {
    int[] answer = new int[]{1, gems.length};

    Set<String> set = new HashSet<>();
    for (int i = 0; i < gems.length; i++) {
      set.add(gems[i]);
    }

    int gemTypes = set.size();

    int start = 0;
    int end = 0;
    int minRange = gems.length;
    int typeCount = 0;

    HashMap<String, Integer> map = new HashMap<>();
    while (end <= gems.length && start <= end) {
      if (end == gems.length && typeCount < gemTypes) {
        break;
      }

      if (typeCount < gemTypes) { //end를 뒤로 미뤄서 전체 포함하도록 하기
        map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
        typeCount = getTypeCount(map, typeCount, gems[end], true);
        end++;
      } else if (typeCount == gemTypes) { //갯수 기록 + start를 뒤로 미뤄서 최소값 구하기
        if (minRange > end - start) {
          minRange = end - start;
          answer[0] = start + 1;
          answer[1] = end;
        }

        map.put(gems[start], map.get(gems[start]) - 1);
        typeCount = getTypeCount(map, typeCount, gems[start], false);
        start++;
      }
    }

    return answer;
  }

  private static int getTypeCount(HashMap<String, Integer> map,
      int typeCount, String currentGem, boolean isPlus) {
    if(isPlus){
      if(map.get(currentGem) == 1){
        typeCount+=1;
      }
    }else{
      if(map.get(currentGem) == 0){
        typeCount-=1;
      }
    }
    return typeCount;
  }
}
