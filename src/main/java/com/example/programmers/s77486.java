package com.example.programmers;

import java.util.HashMap;

public class s77486 {

  private static HashMap<String, Person> people = new HashMap<>();

  public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
    int[] answer = new int[enroll.length];

    getPeopleInfo(enroll, referral);

    for(int i = 0; i < seller.length; i++){
      addAllRef(seller[i], amount[i]);
    }

    for (int i = 0; i < enroll.length; i++) {
      answer[i] = people.get(enroll[i]).amount;
    }
    return answer;
  }

  private static void addAllRef(String seller, int amount) {
    int new_benefit = amount * 100;
    String target = seller;

    while(!target.equals("-")){
      int benefit_10 = (int)(new_benefit * 0.1 );
      people.get(target).amount += (new_benefit - benefit_10);

      target = people.get(target).referral;
      new_benefit = benefit_10;

      if(new_benefit == 0)
        break;
    }
  }

  private static void getPeopleInfo(String[] enroll, String[] referral) {
    for (int i = 0; i < enroll.length; i++) {
      people.put(enroll[i], new Person());
      people.get(enroll[i]).referral = referral[i];
    }
  }

  static class Person {
    private String referral;
    private int amount;
  }
}
