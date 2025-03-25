package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class q21942 {

  private static final int[] MONTH = {0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
  private static int N, F, L;
  private static Info[] infos;

  private static HashMap<String, String> map;
  private static HashMap<String, Long> fin;

  public static void main(String[] args) throws IOException, ParseException {
    run();
  }

  public static void run() throws IOException, ParseException {
    inputData();
    System.out.print(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    String s = st.nextToken();
    L = Integer.parseInt(s.substring(0, 3)) * 24 * 60
        + Integer.parseInt(s.substring(4, 6)) * 60
        + Integer.parseInt(s.substring(7, 9));
    F = Integer.parseInt(st.nextToken());
    infos = new Info[N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      infos[i] = new Info(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken());
    }

    br.close();
  }

  private static String Solution() throws ParseException {
    HashMap<String, String> map = new HashMap<>();
    HashMap<String, Long> fin = new HashMap<>();

    Arrays.sort(infos, (o1, o2) -> {
      if (o1.name.compareTo(o2.name) == 0) {
        if (o1.part.compareTo(o2.part) == 0) {
          if (o1.date.compareTo(o2.date) == 0) {
            return o1.time.compareTo(o2.time);
          }
          return o1.date.compareTo(o2.date);
        }
        return o1.part.compareTo(o2.part);
      }
      return o1.name.compareTo(o2.name);
    });

    for (int i = 0; i < N; i++) {
      String id = infos[i].part + "_" + infos[i].name;

      if (map.containsKey(id)) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        long d1 = format.parse(map.get(id)).getTime();
        long d2 = format.parse(infos[i].date + " " + infos[i].time).getTime();

        long diff = ((d2 - d1) / (1000 * 60));
        if (diff > L) {
          fin.put(infos[i].name, fin.getOrDefault(infos[i].name, 0L) + (diff - L) * F);
        }
        map.remove(id);
      } else {
        map.put(id, infos[i].date + " " + infos[i].time);
      }
    }

    List<String> list = new ArrayList<>(fin.keySet());
    list.sort((s1, s2) -> s1.compareTo(s2));
    StringBuilder sb = new StringBuilder();
    if (fin.size() <= 0) {
      return "-1";
    } else {
      for (String key : list) {
        sb.append(key + " " + fin.get(key)).append("\n");
      }
    }
    return sb.substring(0, sb.length() - 1);


  }

  private static class Info {

    String date;
    String time;
    String part;
    String name;

    public Info(String date, String time, String part, String name) {
      this.date = date;
      this.time = time;
      this.part = part;
      this.name = name;
    }
  }
}
