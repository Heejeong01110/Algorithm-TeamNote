package com.example.programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// 여행 경로
public class s43164 {

  private static String[] answer;

  public static String[] solution(String[][] tickets) {
    answer = new String[tickets.length + 1];

    ArrayList<Ticket> ticketAry = new ArrayList<>();

    for (String[] ticket : tickets) {
      ticketAry.add(new Ticket(ticket[0], ticket[1], false));
    }

    ticketAry.sort((o1, o2) -> {
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


    List<Ticket> ICNArriveList = ticketAry.stream()
        .filter((ticket -> ticket.arrive.equals("ICN") && !ticket.isUsed))
        .collect(Collectors.toList());

    for (int i = 0; i < ICNArriveList.size(); i++) {
      Ticket ticket = ICNArriveList.get(i);

      String[] country = new String[tickets.length + 1];
      country[0] = ticket.arrive;

      ticket.isUsed = true;
      dfs(ticketAry, 1, ticket, country);
      ticket.isUsed = false;
    }

    return answer;
  }

  private static void dfs(ArrayList<Ticket> ticketAry, int count, Ticket currentTicket,
      String[] country) {
    if (answer[0] != null) {
      return;
    }

    if (count == ticketAry.size()) {
      if (answer[0] == null) {
        country[count] = currentTicket.department;
        answer = country.clone();
      }
      return;
    }

    List<Ticket> correctArriveList = ticketAry.stream()
        .filter((ticket -> ticket.arrive.equals(currentTicket.department) && !ticket.isUsed))
        .collect(Collectors.toList());

    for (Ticket ticket : correctArriveList) {
      ticket.isUsed = true;
      country[count] = ticket.arrive;

      dfs(ticketAry, count + 1, ticket, country);

      country[count] = "";
      ticket.isUsed = false;
    }

  }

  private static class Ticket {

    String arrive;
    String department;
    boolean isUsed;

    public Ticket(String arrive, String department, boolean isUsed) {
      this.arrive = arrive;
      this.department = department;
      this.isUsed = isUsed;
    }
  }
}
