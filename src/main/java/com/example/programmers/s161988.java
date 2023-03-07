package com.example.programmers;

public class s161988 {

  public long solution(int[] sequence) {

    long[] pulseList = new long[sequence.length + 1];
    for (int i = 0; i < pulseList.length; i++) {
      pulseList[i] = (i % 2 == 0 ? 1 : -1);
    }

    long[] sumList = new long[sequence.length + 1];
    sumList[0] = sequence[0] * pulseList[0];
    for (int i = 1; i < sequence.length; i++) {
      sumList[i] = sumList[i - 1] + sequence[i] * pulseList[i];
    }

    long min = 0;
    long max = 0;
    for (long item : sumList) {
      if (item > 0) {
        max = Math.max(max, item);
      } else if (item < 0) {
        min = Math.min(min, item);
      }
    }
    return  max - min;
  }
}
