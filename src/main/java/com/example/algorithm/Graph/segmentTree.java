package com.example.algorithm.Graph;

public class segmentTree {

  private static long[] arr, tree;

  public static void main(String[] args) {

    arr = new long[]{1, 9, 3, 8, 4, 5, 5, 9, 10, 3, 4, 5};
    int k = (int) Math.ceil(Math.log(arr.length) / Math.log(2)) + 1;
    int size = (int) Math.pow(2, k);
    //int size  = arr.length*4;
    tree = new long[size];

    init(1, arr.length, 1);
  }


  // start: 시작 인덱스, end: 끝 인덱스
  private static long init(int start, int end, int node) {
    if (start == end) {
      return tree[node] = arr[start];
    }

    int mid = (start + end) / 2;

    // 재귀적으로 두 부분으로 나눈 뒤에 그 합을 자기 자신으로 함.
    tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    return tree[node];
  }

  // start: 시작 인덱스, end: 끝 인덱스
  // left, right: 구간 합을 구하고자 하는 범위
  private static long sum(int start, int end, int node, int left, int right) {
    // 범위 밖에 있는 경우
    if (left > end || right < start) {
      return 0;
    }

    // 범위 안에 있는 경우
    if (left <= start && end <= right) {
      return tree[node];
    }

    // 그렇지 않다면, 두 부분으로 나누어 합을 구하기
    int mid = (start + end) / 2;
    return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
  }

  // start: 시작 인덱스, end: 끝 인덱스
  // idx: 구간 합을 수정하고자 하는 노드
  // dif: 수정할 값
  private static void update(int start, int end, int node, int idx, long dif) {
    // 범위 밖에 있는 경우
    if (idx < start || idx > end) {
      return;
    }

    // 범위 안에 있으면 내려가며 다른 원소도 갱신
    tree[node] += dif;
    if (start == end) {
      return;
    }

    int mid = (start + end) / 2;
    update(start, mid, node * 2, idx, dif);
    update(mid + 1, end, node * 2 + 1, idx, dif);
  }
}
