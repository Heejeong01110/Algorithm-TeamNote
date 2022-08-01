package com.example.programmers.exam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class s1 {
  public String solution(String X, String Y) {
    String answer = "";

    HashMap<String, Integer> xMap = new HashMap<>();
    HashMap<String, Integer> yMap = new HashMap<>();

    for(int i=0;i<X.length();i++){
      xMap.put(X.substring(i, i+1), xMap.getOrDefault(X.substring(i, i+1),0) + 1);
    }
    for(int i=0;i<Y.length();i++){
      yMap.put(Y.substring(i, i+1), yMap.getOrDefault(Y.substring(i, i+1),0) + 1);
    }

    ArrayList<String> match = new ArrayList<>();


    List<Map.Entry<String, Integer>> entryList = new LinkedList<>(xMap.entrySet());
    for(int i=0;i<entryList.size();i++){
      String word = entryList.get(i).getKey();
      int count = Math.min(xMap.get(word), yMap.getOrDefault(word, 0));

      for(int j=0;j<count;j++){
        match.add(word);
      }
    }

    boolean isAllZero = true;
    for(int i=0;i<match.size();i++){
      if(!match.get(i).equals("0")){
        isAllZero = false;
        break;
      }
    }

    if(isAllZero && match.size() >0){
      return "0";
    }


    match.sort(Comparator.reverseOrder());
    StringBuilder sb = new StringBuilder();
    for(int i=0;i<match.size();i++){
        sb.append(match.get(i));
    }

    if(sb.toString().equals("")){
      return "-1";
    }
    return sb.toString();
  }
}
