package com.example.Exam.skill_checks;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

//보드게임
public class s2 {

  public int solution(int[][] board, int[] aloc, int[] bloc) {
    //이동 가능한 칸의 갯수가 홀, 짝인지에 따라 항상 이기는 플레이어가 결정됨
    //짝 : B, 홀 : A

    Queue<Node> winner = new ArrayDeque<>();
    Queue<Node> looser = new ArrayDeque<>();

    //지정하는 로직 필요
    winner.add(new Node(aloc[0], aloc[1]));
    looser.add(new Node(bloc[0], bloc[1]));


    int answer = -1;
    return answer;
  }

  private static class Node{
    int row;
    int col;

    public Node(int row, int col) {
      this.row = row;
      this.col = col;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Node)) {
        return false;
      }
      Node node = (Node) o;
      return row == node.row && col == node.col;
    }

    @Override
    public int hashCode() {
      return Objects.hash(row, col);
    }
  }

}
