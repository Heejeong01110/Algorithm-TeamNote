package com.example.algorithm.sortAndSearch.sort;

import java.util.ArrayList;

public class CustomClassArrayListSort {
//String 사전 순 정렬
  public static void main(String[] args) {
    String[][] tickets = new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"},
        {"ATL", "ICN"},
        {"ATL", "SFO"},
        {"ATL", "ABC"},
        {"ATL", "EFA"},
        {"ATL", "TTT"}};
    ArrayList<CustomClass> arrayList = new ArrayList<>();

    for (String[] ticket : tickets) {
      arrayList.add(new CustomClass(ticket[0], ticket[1]));
    }

    arrayList.sort((o1, o2) -> {
      if (o1.arrive.compareTo(o2.arrive) > 0) { //o1이 더 사전순으로 앞글자
        return 1;
      } else if (o1.arrive.compareTo(o2.arrive) == 0) { //같은글자
        if (o1.department.compareTo(o2.department) > 0) { //o1이 더 사전순으로 앞글자
          return 1;
        } else if (o1.department.compareTo(o2.department) == 0) {
          return 0;
        } else {
          return -1;
        }
      } else {//o2가 더 사전순으로 앞글자
        return -1;
      }
    });

    for (int i = 0; i < arrayList.size(); i++) {
      System.out.println(arrayList.get(i).toString());
    }
  }

  private static class CustomClass {

    String arrive;
    String department;

    public CustomClass(String arrive, String department) {
      this.arrive = arrive;
      this.department = department;
    }

    @Override
    public String toString() {
      return "CustomClass{" +
          "arrive='" + arrive + '\'' +
          ", department='" + department + '\'' +
          '}';
    }
  }

}
