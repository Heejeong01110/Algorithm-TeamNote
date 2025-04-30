package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class q12793 {

  // 상하좌우 + 자기 위치(visit 마킹용)
  static final int[] dx = {0, 0, -1, 1, 0};
  static final int[] dy = {-1, 1, 0, 0, 0};
  // 대각선 이동용
  static final int[] dx_ = {-1, 1, 1, -1};
  static final int[] dy_ = {-1, -1, 1, 1};
  static int N, M, dab = 0;
  static double K;
  static char[][] map;
  static int[][] visit;
  static boolean[] broken;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    K = Double.parseDouble(st.nextToken());

    // 맵과 방문 배열 초기화
    map = new char[2 * N + 1][2 * M + 1];
    for (int i = 0; i < 2 * N + 1; i++) {
      map[i] = br.readLine().toCharArray();
    }
    visit = new int[2 * N + 1][2 * M + 1];
    // 블록 개수(최대 N*M) + 여유분
    broken = new boolean[N * M + 5];

    // B 블록마다 BFS로 연결된 같은 블록 그룹 번호 매기기
    int blockCnt = 0;
    for (int y = 0; y < 2 * N + 1; y++) {
      for (int x = 0; x < 2 * M + 1; x++) {
        if (map[y][x] == 'B' && visit[y][x] == 0) {
          bfs(x, y, ++blockCnt);
        }
      }
    }

    // 공 발사 시작 좌표
    int ix = (int) Math.floor(2 * K);
    int iy = 2 * N;
    dfs(0, ix, iy, 0);

    System.out.println(dab);
  }

  // BFS로 빈 칸(.) 또는 B 칸을 탐색해 visit에 그룹 번호 표시
  static void bfs(int sx, int sy, int group) {
    Deque<int[]> queue = new ArrayDeque<>();
    queue.add(new int[]{sx, sy});
    visit[sy][sx] = group;

    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      int cx = cur[0], cy = cur[1];

      for (int i = 0; i < 4; i++) {
        int nx = cx + dx[i];
        int ny = cy + dy[i];
        if (nx < 0 || ny < 0 || nx >= 2 * M + 1 || ny >= 2 * N + 1) {
          continue;
        }
        if (visit[ny][nx] != 0) {
          continue;
        }
        char c = map[ny][nx];
        if (c != '.' && c != 'B') {
          continue;
        }
        visit[ny][nx] = group;
        queue.add(new int[]{nx, ny});
      }
    }
  }

  // 대각선으로 튕기며 이동하다가 바닥에서 멈춘 뒤 주변 블록을 집계
  static void dfs(int depth, int x, int y, int dir) {
    // 이미 한 번 움직였고, y가 바닥(2*N+1)을 넘어가면 멈춤
    if (depth != 0 && y == 2 * N + 1) {
      return;
    }

    // 일단 대각선 이동
    int nx = x + dx_[dir];
    int ny = y + dy_[dir];

    // 경계 반사 처리
    if (nx < 0) {
      dir = (dir == 0 ? 1 : 2);
    } else if (ny < 0) {
      dir = (dir == 1 ? 2 : 3);
    } else if (nx > 2 * M) {
      dir = (dir == 2 ? 3 : 0);
    }

    nx = x + dx_[dir];
    ny = y + dy_[dir];

    dfs(depth + 1, nx, ny, dir);

    // 착지 지점 주변과 자기 위치의 블록 그룹을 한 번만 세기
    markBroken(x, y - 1);
    markBroken(x, y + 1);
    markBroken(x, y);
  }

  // visit[yy][xx]가 0이 아니고 아직 broken 표시가 없으면 카운트
  static void markBroken(int xx, int yy) {
    if (yy < 0 || yy >= 2 * N + 1 || xx < 0 || xx >= 2 * M + 1) {
      return;
    }
    int grp = visit[yy][xx];
    if (grp != 0 && !broken[grp]) {
      broken[grp] = true;
      dab++;
    }
  }
}
