package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q16434 {

  private static int N;
  private static int hAtk;
  private static Room[] rooms;

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

    N = Integer.parseInt(st.nextToken());
    hAtk = Integer.parseInt(st.nextToken());
    rooms = new Room[N + 1];

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());

      int one = Integer.parseInt(st.nextToken());
      long two = Integer.parseInt(st.nextToken());
      long thr = Integer.parseInt(st.nextToken());

      rooms[i] = new Room(one, two, thr);
    }

    br.close();
  }

  private static long Solution() {
    long start = 0;
    long end = ((long)2 << 62) - 1;
    long mid = 0;
    long answer = 0;

    while (end >= start) {
      mid = (start + end) / 2;
      if (check(mid)) {
        end = mid - 1;
        answer = mid;
      } else {
        start = mid + 1;
      }
    }

    return answer;
  }


  private static boolean check(long value) {
    long atk = hAtk;
    long hp = value;

    for (int i = 1; i <= N; i++) {
      if (rooms[i].type == 1) { //몬스터
        long count = rooms[i].hp / atk;
        if (rooms[i].hp % atk == 0) {
          count -= 1;
        }

        hp -= count * rooms[i].atk;
        if (hp <= 0) {
          return false;
        }

      } else { //회복
        atk += rooms[i].atk;
        hp = Math.min(value, hp + rooms[i].hp);
      }
    }

    return true;
  }

  private static class Room {

    int type; // 1, 2
    long atk;
    long hp;

    public Room(int type, long atk, long hp) {
      this.type = type;
      this.atk = atk;
      this.hp = hp;
    }
  }
}
