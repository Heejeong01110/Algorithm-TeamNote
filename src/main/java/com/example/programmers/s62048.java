package com.example.programmers;

import java.math.BigInteger;

public class s62048 {

  private static int[] w;
  private static int[] h;
  private static int[] result;

  public static long Solution(int w, int h) {
    long answer = 0;
    for(int x=0; x<w; x++){
      answer += Math.ceil((double)h*(x+1)/w)-Math.floor((double)h*x/w);
    }
    return (long)h*w-answer;
  }

  public static long solution2(int w, int h) {
    int gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue();
    return ((long) w * (long) h) - ((((long) w / gcd) + ((long) h / gcd) - 1) * gcd);
  }

}
