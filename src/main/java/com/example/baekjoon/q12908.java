package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class q12908 {

  private static Node start;
  private static Node end;
  private static Node[] teleport;
  private static Long minTime;
  private static HashMap<String, Long> memos;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    output(Solution());
  }

  private static void output(long result) {
    System.out.print(result);
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());
    start = new Node(x, y, null);

    st = new StringTokenizer(br.readLine());
    x = Integer.parseInt(st.nextToken());
    y = Integer.parseInt(st.nextToken());
    end = new Node(x, y, null);

    teleport = new Node[6];
    int nx, ny;
    for (int i = 0; i < 3; i++) {
      st = new StringTokenizer(br.readLine());
      x = Integer.parseInt(st.nextToken());
      y = Integer.parseInt(st.nextToken());

      nx = Integer.parseInt(st.nextToken());
      ny = Integer.parseInt(st.nextToken());

      teleport[i] = new Node(x, y, null);
      teleport[i + 3] = new Node(nx, ny, teleport[i]);
      teleport[i].link = teleport[i + 3];
    }

    br.close();
  }

  private static long Solution() {
    memos = new HashMap<>();
    minTime = (long) Math.abs(end.x - start.x) + Math.abs(end.y - start.y);

    dfs(start, 0L, new boolean[3], 0, "");

    return minTime;
  }

  private static void dfs(Node now, Long time, boolean[] visited, int depth, String memo) {
    //그 전에 최소 시간보다 클 경우에는 바로 리턴
    if (time >= minTime) {
      return;
    }

    if (depth == 3) { //포탈 통과 순서 획득
      if (!memo.isBlank() && !memos.containsKey(memo)) {//처음 연산
        long allTime = time + (Math.abs(end.x - now.x) + Math.abs(end.y - now.y));
        memos.put(memo, allTime);
        minTime = Math.min(minTime, allTime);
      }
      //이미 저장했을 경우 그냥 리턴
      return;
    }

    dfs(now, time, visited, depth + 1, memo);//포탈을 안탄 경우
    for (int i = 0; i < 3; i++) {
      if (visited[i]) {
        continue;
      }

      int shortPortal = findShort(now, teleport[i]);
      int departX = teleport[i + shortPortal].link.x;
      int departY = teleport[i + shortPortal].link.y;

      Node move = new Node(departX, departY, null);
      Long moveTime = time + Math.abs(teleport[i + shortPortal].x - now.x) + Math.abs(
          teleport[i + shortPortal].y - now.y) + 10;
      visited[i] = true;
      dfs(move, moveTime, visited, depth + 1, memo + i);//i 포탈을 탄 경우
      visited[i] = false;

    }
  }

  private static int findShort(Node now, Node target) {//0 반환시 본인, 3반환시 반대쪽이 더 가까움
    int nowToTarget = Math.abs(target.x - now.x) + Math.abs(target.y - now.y);
    int nowToNear = Math.abs(target.link.x - now.x) + Math.abs(target.link.y - now.y);

    if (nowToTarget < nowToNear) {
      return 0;
    }
    return 3;

  }

  private static class Node {

    int x;
    int y;
    Node link;

    public Node(int x, int y, Node link) {
      this.x = x;
      this.y = y;
      this.link = link;
    }
  }


}
