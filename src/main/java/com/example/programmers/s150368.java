package com.example.programmers;

public class s150368 {

  private static int[] SALES = new int[]{10, 20, 30, 40};
  private static int[] result;

  public static int[] solution(int[][] users, int[] emoticons) {
    result = new int[2];
    saleDfs(users, emoticons, new int[emoticons.length], 0);
    return result;
  }

  private static void saleDfs(int[][] users, int[] emoticons, int[] saleVisited, int depth) {

    if (depth == emoticons.length) {
      getUserPrices(users, emoticons, saleVisited);
      return;
    }

    for (int i = 0; i < SALES.length; i++) {
      saleVisited[depth] = i;
      saleDfs(users, emoticons, saleVisited, depth + 1);
    }

  }

  private static void getUserPrices(int[][] users, int[] emoticons, int[] saleVisited) {
    int plusCnt = 0;
    int total = 0;

    for (int[] user : users) {
      int price = 0;
      for (int j = 0; j < emoticons.length; j++) {
        if (user[0] <= SALES[saleVisited[j]]) {
          price += (emoticons[j] * (100 - SALES[saleVisited[j]]) / 100);
        }
      }

      if (price >= user[1]) {
        plusCnt++;
      } else {
        total += price;
      }
    }

    if (result[0] < plusCnt) {
      result[0] = plusCnt;
      result[1] = total;
    } else if (result[0] == plusCnt && result[1] < total) {
      result[1] = total;
    }
  }
}
