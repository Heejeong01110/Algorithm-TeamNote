package com.example.algorithm.sortAndSearch;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HashMapValueSort {

  public static void main(String[] args) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(1, 4);
    map.put(2, 5);
    map.put(3, 6);

    List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
    entryList.sort((o1, o2) -> o2.getValue() - o1.getValue());

    for(Map.Entry<Integer, Integer> entry : entryList){
      System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
    }

//key : 1, value : 4
//key : 2, value : 5
//key : 3, value : 6
  }

}
