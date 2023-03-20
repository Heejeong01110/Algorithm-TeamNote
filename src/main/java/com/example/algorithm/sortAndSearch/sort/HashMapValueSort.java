package com.example.algorithm.sortAndSearch.sort;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HashMapValueSort {

  public static void main(String[] args) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(2, 5);
    map.put(5, 4);
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

    map.putIfAbsent(5, 4);
    /*
      key 값이 존재하는 경우 Map의 value 값을 반환
      key 값이 존재하지 않는 경우 key와 value를 Map에 저장하고 null을 반환
    */

    map.computeIfAbsent(99, key -> key / 3);
    /*
      key 값이 존재하는 경우 map안에 있는 value을 반환한다
      key 값이 존재하지 않는 경우 람다 함수를 실행한 결과 값을 저장한다
    */

    map.compute(99, (k, v) -> v + 50);
    // key 값이 없을경우 NPE 발생
    // key가 존재할 경우 람다식 실행 결과값을 저장한다.

    map.computeIfPresent(99, (k, v) -> v + 10);
    // key 값이 없을경우 null 반환
    // key가 존재할 경우 람다식 실행 결과값을 저장한다.

    map.merge(99, 1000, (k, v) -> map.get(98));
    // key가 존재하지 않는 경우 (99,1000) 값이 추가됨
    // key값이 존재할 경우 merge 람다식이 참일경우 1000으로 업데이트, 거짓일 경우 key를 삭제

    // key : 100, value : 1
    // key : 7, value : 2
    // key : 1, value : 4
    // key : 5, value : 4
    // key : 2, value : 5
    // key : 3, value : 6
  }

}
