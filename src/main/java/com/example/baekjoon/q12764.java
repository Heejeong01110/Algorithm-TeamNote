package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q12764 {

  private static int N;
  private static int[][] input;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    output(Solution());
  }

  private static void output(String result) {
    System.out.print(result);
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    input = new int[N][2];

    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      input[i][0] = Integer.parseInt(st.nextToken());
      input[i][1] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static String Solution() {
    Arrays.sort(input, (o1, o2) -> {
      if (o1[0] == o2[0]) {
        return o1[1] - o2[1]; //오름차순
      }
      return o1[0] - o2[0];//오름차순
    });

    int[] seat = new int[input.length];

    Integer maxSeatNumber = 0; //가장 큰 수의 좌석번호  (중간 번호는 따로 계산)
    PriorityQueue<Seat> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.endTime));
    PriorityQueue<Integer> seatNumber = new PriorityQueue<>(); //빈자리 저장 큐

    for (int i = 0; i < N; i++) {
      //1. 입장시간보다 작은 seat 모두 삭제
      while (!queue.isEmpty()) { //빈자리 기록 모두 삭제
        if (queue.peek().endTime < input[i][0]) {
          seatNumber.add(queue.poll().index);
        } else {
          break;
        }
      }

      //2. 좌석 배정
      Integer seatNum = -1;
      if (!seatNumber.isEmpty()) { //2-1. 중간에 빈 좌석이 있을 때
        seatNum = seatNumber.poll();
      } else { //2-2. 중간에 빈 좌석 없이 새로운 좌석에 앉을 때
        seatNum = queue.size();
      }
      seat[seatNum] += 1;
      maxSeatNumber = Math.max(maxSeatNumber, seatNum);
      queue.add(new Seat(seatNum, input[i][1]));

    }

    StringBuilder sb = new StringBuilder();
    sb.append(maxSeatNumber + 1).append("\n");
    for (int i = 0; i < seat.length; i++) {
      if (seat[i] == 0) {
        break;
      }

      sb.append(seat[i]).append(" ");
    }

    return sb.toString();
  }

  private static class Seat {

    int index;
    int endTime;

    public Seat(int index, int endTime) {
      this.index = index;
      this.endTime = endTime;
    }
  }

}
