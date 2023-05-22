package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class q1700 {

  private static int N, K, count;
  private static int[] nums;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    output(Solution());
  }

  private static void output(int result) {
    System.out.print(result);
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    nums = new int[K];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < K; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }
    br.close();
  }

  private static int Solution() {
    ArrayList<Integer> plug = new ArrayList<>();
    count = 0;

    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    }

    for (int i = 0; i < K; i++) {
      //0. 이미 꽂혀있을 때
      if (plug.contains(nums[i])) {
        map.put(nums[i], map.get(nums[i]) - 1);
        continue;
      }

      //0. 끼울 자리가 있을 때
      if (plug.size() < N) {
        plug.add(nums[i]);
        map.put(nums[i], map.get(nums[i]) - 1);
        continue;
      }

      //1. plug에 있는 수 중에서 더이상 나오지 않는 수가 있으면 플러그 뽑기
      if (removeAllUsedPlug(plug, map)) {
        plug.add(nums[i]);
        map.put(nums[i], map.get(nums[i]) - 1);
        continue;
      }

      //2. plug에 있는 수 중에서 가장 나중에 등장하는 플러그 뽑기
      int index = 0;
      int last = 0;
      for (int j = 0; j < plug.size(); j++) {
        for (int k = i; k < K; k++) {
          if (nums[k] == plug.get(j)) {
            if (k > last) {
              index = j;
              last = k;
            }
            break;
          }
        }

      }

      plug.remove(index);
      plug.add(nums[i]);
      map.put(nums[i], map.get(nums[i]) - 1);
      count++;
    }

    return count;
  }

  private static boolean removeAllUsedPlug(ArrayList<Integer> plug, HashMap<Integer, Integer> map) {
    for (int j = 0; j < plug.size(); j++) {
      if (map.get(plug.get(j)) == 0) {
        plug.remove(j);
        count++;
        return true;
      }
    }
    return false;
  }

}
