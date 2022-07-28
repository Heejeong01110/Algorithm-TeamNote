package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class q1043 {

  public static int[] parent;
  private static int N;
  private static int M;
  private static ArrayList<Integer>[] partyList;
  private static ArrayList<Integer>[] people;
  private static ArrayList<Integer> truth;
  private static int truthCount;
  private static boolean[] result;

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
    M = Integer.parseInt(st.nextToken());

    truth = new ArrayList<>();
    st = new StringTokenizer(br.readLine());
    truthCount = Integer.parseInt(st.nextToken());
    for (int i = 0; i < truthCount; i++) {
      truth.add(Integer.parseInt(st.nextToken()));
    }

    partyList = new ArrayList[M];
    people = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      people[i] = new ArrayList<>();
    }
    for (int i = 0; i < M; i++) {
      partyList[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int count = Integer.parseInt(st.nextToken());
      for (int j = 0; j < count; j++) {
        int pIdx = Integer.parseInt(st.nextToken());
        partyList[i].add(pIdx);
        people[pIdx].add(i);
      }
    }

    br.close();
  }

  private static int Solution() {
    if (truthCount == 0) {
      return M;
    }

    parent = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      parent[i] = i;
    }

    for (int i = 0; i < M; i++) {
      if (partyList[i].size() <= 1) {
        continue;
      }

      int temp = partyList[i].get(0);
      for (int j = 1; j < partyList[i].size(); j++) {
        union(temp, partyList[i].get(j));
      }
    }

    for (int i = 0; i < truth.size(); i++) {

      for (int j = 1; j <= N; j++) {
        if (j != truth.get(i) && isSameParent(j, truth.get(i)) && !truth.contains(j)) {
          truth.add(j);
        }
      }
    }

    boolean[] result = new boolean[M];
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < truth.size(); j++) {
        if (partyList[i].contains(truth.get(j))) {
          result[i] = true;
          break;
        }
      }
    }

    int res = 0;
    for (int i = 0; i < result.length; i++) {
      if (result[i]) {
        res++;
      }
    }
    return M - res;
  }

  private static int find(int x) {
    if (x == parent[x]) {
      return x;
    } else {
      return parent[x] = find(parent[x]);
    }
  }

  private static void union(int x, int y) {
    x = find(x);
    y = find(y); // 같은 부모를 가지고 있지 않을 때
    if (x != y) { // y가 x 보다 크다는 것을 가정한다면 아래와 같이 표현
      parent[y] = x;
    }
  }

  // 같은 부모 노드를 가지는지 확인
  private static boolean isSameParent(int x, int y) {
    x = find(x);
    y = find(y);
    if (x == y) {
      return true;
    } else {
      return false;
    }
  }

  private static void checkTruthByPerson(int person) {
    for (int i = 0; i < people[person].size(); i++) {
      //1. 이 사람이 참여한 거짓말 파티 진실로 변경
      int party = people[person].get(i);

      if (!result[party]) {
        result[party] = true;
        //2. 새롭게 진실을 말하도록 한 경우 해당 파티 참석자들도 진실로 체크
        checkTruthByParty(party);
      }
    }
  }

  private static void checkTruthByParty(Integer party) {
    for (int i = 0; i < partyList[party].size(); i++) {
      //1. 해당 파티에 참여한 사람들은 진실을 알고있다고 체크
      int person = partyList[party].get(i);
      if (!truth.contains(person)) {
        truth.add(person);
        //2. 새롭게 진실을 들은 사람들은 그 사람이 참여한 파티들마다 진실만 말해야 함
        checkTruthByPerson(person);
      }
    }
  }


}
