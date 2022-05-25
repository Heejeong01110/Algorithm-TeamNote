package com.example.algorithm.Greedy;

import java.util.Arrays;
import java.util.List;

// 일정한 가치와 무게가 정해져있는 짐들을 배낭에 넣을 때
// 가치의 합이 최대가 되도록 짐을 고르는 방법을 찾는 알고리즘
public class Knapsack {

  public static void main(String[] args) {
    runFractionalKnapsack();
    runDpKnapsack();

  }

  private static void runDpKnapsack() {
    int[] weight = new int[]{6, 4, 3, 5};
    int[] value = new int[]{13, 8, 6, 12};
    int result = dpKnapsack(4, 7, weight, value);
    System.out.println(result);
  }

  //물건을 쪼갤 수 없을 경우
  //N : 물건의 갯수, K : 짐의 최대 무게, weight : 각 물건의 무게, value : 각 물건의 가치
  private static int dpKnapsack(int N, int K, int[] weight, int[] value) {
    int[][] dp = new int[N + 1][K + 1];
    int max = 0;

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= K; j++) {

        if (weight[i - 1] <= j) {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
        } else {
          dp[i][j] = dp[i - 1][j];
        }
        max = Math.max(dp[i][j], max);
      }
    }
    return max;
  }


  private static void runFractionalKnapsack() {
    List<Item> items = Arrays.asList(
        new Item(6, 13),
        new Item(4, 8),
        new Item(3, 6),
        new Item(5, 12)
    );

    double maxValue = fractionalKnapsack(items, 7);
    System.out.println("최대가치 합은 = " + maxValue);
  }

  // 물건을 쪼갤 수 있는 경우
  // 항목의 가치/무게의 비율을 계산하고 비율을 기준으로 항목을 정렬한다.
  public static double fractionalKnapsack(List<Item> items, double capacity) {
    items = items.stream().sorted((a, b) -> {
      double aRatio = a.value / a.weight;
      double bRatio = b.value / b.weight;
      return Double.compare(aRatio, bRatio);
    }).toList();

    double totalValue = 0;
    double curCapacity = capacity;
    for (Item item : items) {
      // 현재 가방의 무게를 담을수 있는 상황이라면
      if (item.weight < curCapacity) {
        curCapacity -= item.weight;
        totalValue += item.value;
      } else { // 담을수 없는 상황이면 쪼개서 담아라.
        double fraction = ((double) capacity / (double) item.weight);
        totalValue += (item.value * fraction);
        break;
      }
    }
    return totalValue;
  }

  private static class Item {

    double weight;
    double value;

    public Item(double weight, double value) {
      this.weight = weight;
      this.value = value;
    }
  }
}
