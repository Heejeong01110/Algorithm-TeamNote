package com.example.programmers;

import java.util.ArrayList;

public class s17683 {

  public static String solution(String m, String[] musicinfos) {
    ArrayList<MusicInfo> infos = new ArrayList<>();
    for (int i = 0; i < musicinfos.length; i++) {
      String[] musicinfo_spl = musicinfos[i].split(",");
      infos.add(
          new MusicInfo(i, timeToMin(musicinfo_spl[0]), timeToMin(musicinfo_spl[1]),
              musicinfo_spl[2], musicinfo_spl[3]));
    }

    infos.sort((o1, o2) -> {
      if (o1.end - o1.start == o2.end - o2.start) {
        return o1.idx - o2.idx;
      }
      return (o2.end - o2.start) - (o1.end - o1.start);
    });

    String answer = "(None)";
    ArrayList<String> codes = getCodes(m);

    for (MusicInfo info : infos) {
      if (checkMusic(codes, getFullInfo(info.end - info.start, info.info))) {
        return info.name;
      }
    }

    return answer;
  }

  private static ArrayList<String> getCodes(String info) {
    ArrayList<String> codes = new ArrayList<>();
    for (int i = 0; i < info.length(); i++) {
      if (info.charAt(i) == '#') {
        codes.add(codes.remove(codes.size() - 1) + "#");
      } else {
        codes.add(info.substring(i, i + 1));
      }
    }
    return codes;
  }


  public static int timeToMin(String time) {
    String[] info = time.split(":");
    return Integer.parseInt(info[0]) * 60 + Integer.parseInt(info[1]);
  }

  private static ArrayList<String> getFullInfo(int len, String info) {
    ArrayList<String> fullInfo = new ArrayList<>();
    ArrayList<String> codes = getCodes(info);

    for (int i = 0; i < len; i++) {
      fullInfo.add(codes.get(i % codes.size()));
    }

    return fullInfo;
  }

  private static boolean checkMusic(ArrayList<String> codes, ArrayList<String> fullInfo) {
    for (int i = 0; i < fullInfo.size() - codes.size() + 1; i++) {
      boolean temp = true;
      for (int j = 0; j < codes.size(); j++) {
        if (!fullInfo.get(i + j).equals(codes.get(j))) {
          temp = false;
          break;
        }
      }

      if (temp) {
        return true;
      }
    }
    return false;
  }


  public static class MusicInfo {

    int idx;
    int start;
    int end;
    String name;
    String info;

    public MusicInfo(int idx, int start, int end, String name, String info) {
      this.idx = idx;
      this.start = start;
      this.end = end;
      this.name = name;
      this.info = info;
    }
  }
}
