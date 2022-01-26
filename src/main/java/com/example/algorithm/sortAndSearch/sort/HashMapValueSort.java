package com.example.algorithm.sortAndSearch.sort;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HashMapValueSort {

  public static void main(String[] args) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(2, 5);
    map.put(1, 4);
    map.put(3, 6);
    map.put(100, 1);
    map.put(7, 2);

    List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
    entryList.sort((o1, o2) -> o2.getValue() - o1.getValue()); //value 내림차순 정렬

    entryList.sort((o1, o2) -> o1.getValue() - o2.getValue()); //value 오름차순 정렬

    for (Map.Entry<Integer, Integer> entry : entryList) {
      System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
    }

//key : 1, value : 4
//key : 2, value : 5
//key : 3, value : 6
  }

}
