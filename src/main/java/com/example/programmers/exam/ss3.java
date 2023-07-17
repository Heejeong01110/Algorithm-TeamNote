package com.example.programmers.exam;

import java.util.ArrayList;

public class ss3 {

  private static ArrayList<RepName> repNames;

  public static String[] solution(String[] merchantNames) {
    String[] answer = {};

    repNames = new ArrayList<>();
    for (String name : merchantNames) {
      if (!containName(repNames, name)) {
        repNames.add(new RepName(removeRep(name), name));
      }
    }

    answer = new String[repNames.size()];
    for (int i = 0; i < repNames.size(); i++) {
      answer[i] = repNames.get(i).containSpecial;
    }
    return answer;
  }

  private static String removeRep(String name) {
    return name.replaceAll("[ &().,-]", "");
  }

  private static boolean containName(ArrayList<RepName> repNames, String name) {
    for (int i = 0; i < repNames.size(); i++) {
      RepName repName = repNames.get(i);
      String exist = repName.notSpecial;
      String newName = removeRep(name);

      if (exist.length() > newName.length() && exist.startsWith(newName)) {
        return true;
      } else if (exist.length() == newName.length()) {
        //1. 특수문자가 더 많이 포함되어있는 문장
        String removeSpec1 = repName.containSpecial.replaceAll("[^&().,-]", "");
        String removeSpec2 = name.replaceAll("[^&().,-]", "");

        if (removeSpec1.length() < removeSpec2.length()) {
          repNames.get(i).containSpecial = name;
        }
        return true;
      } else if (exist.length() < newName.length() && newName.startsWith(exist)) {
        repNames.get(i).notSpecial = newName;
        repNames.get(i).containSpecial = name;
        return true;
      }
    }
    return false;
  }

  private static class RepName {

    String notSpecial;
    String containSpecial;

    public RepName(String notSpecial, String containSpecial) {
      this.notSpecial = notSpecial;
      this.containSpecial = containSpecial;
    }
  }

}
