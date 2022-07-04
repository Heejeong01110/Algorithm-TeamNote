package com.example.programmers;

import java.util.HashMap;

public class s64063 {

  private static HashMap<Long, Long> map = new HashMap<>();

  public static long[] solution(long k, long[] room_number) {
    long[] result = new long[room_number.length];

    for (int i = 0; i < room_number.length; i++) {
      result[i] = findRoom(room_number[i]);

    }
    return result;
  }

  private static long findRoom(long idx) {
    if (!map.containsKey(idx)) {
      map.put(idx, idx + 1);
      return idx;
    }

    long nextIdx = map.get(idx);
    long empty = findRoom(nextIdx);
    map.put(idx, empty);
    return empty;
  }
}
