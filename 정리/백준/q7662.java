import java.io.*;
import java.util.*;

public class q7662 {
  static private BufferedReader br;
  static private StringTokenizer st;
  static private String method;
  static private Integer value;
  static private Integer calc;
  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    Integer testCase = Integer.parseInt(br.readLine());

    for (int tc = 0; tc < testCase; tc++) {
      solution2();
    }

    br.close();
  }

  
  private static void solution() throws IOException {
    Map<Integer, Integer> map = new HashMap<>();
    PriorityQueue<Integer> minQue = new PriorityQueue<>();
    PriorityQueue<Integer> maxQue = new PriorityQueue<>(Collections.reverseOrder());

    calc = Integer.parseInt(br.readLine());

    for (int i = 0; i < calc; i++) {
      st = new StringTokenizer(br.readLine());
      method = st.nextToken();
      value = Integer.parseInt(st.nextToken());

      if (method.equals("I")) {

        map.put(value, map.getOrDefault(value, 0) + 1);
        minQue.add(value);
        maxQue.add(value);

      } else if (method.equals("D")) {
        if (map.size() == 0) {
          continue;
        }

        PriorityQueue<Integer> que = value == 1 ? maxQue : minQue;
        removeMap(que, map);
      }
    }

    if (map.size() == 0) {
      System.out.println("EMPTY");
    } else {
      int max = removeMap(maxQue, map);
      System.out.println(max + " " + (map.size() > 0 ? removeMap(minQue, map) : max));
    }

  }
  
  private static void solution2() throws IOException {
    TreeMap<Integer, Integer> map = new TreeMap<>();

    calc = Integer.parseInt(br.readLine());

    for (int i = 0; i < calc; i++) {
      st = new StringTokenizer(br.readLine());
      method = st.nextToken();
      value = Integer.parseInt(st.nextToken());

      if (method.equals("I")) {

        map.put(value, map.getOrDefault(value, 0) + 1);

      } else if (method.equals("D")) {
        if (map.size() == 0) {
          continue;
        }

        int num = value == 1 ? map.lastKey() : map.firstKey();
        map.put(num, map.get(num) - 1);
        if (map.get(num) == 0) {
          map.remove(num);
        }
      }
    }

    if (map.size() == 0) {
      System.out.println("EMPTY");
    } else {
      int max = map.lastKey();
      System.out.println(max + " " + (map.size() > 0 ? map.firstKey(): max));
    }

  }

  static int removeMap(PriorityQueue<Integer> que, Map<Integer, Integer> map) {
    int num;
    while (true) {
      num = que.poll();
      int cnt = map.getOrDefault(num, 0);

      if (cnt == 0)
        continue;

      if (cnt == 1)
        map.remove(num);
      else
        map.put(num, cnt - 1);

      break;
    }

    return num;
  }
  
}
