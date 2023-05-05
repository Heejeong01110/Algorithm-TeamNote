package com.example.programmers;

import java.util.ArrayList;
import java.util.Collections;

public class s131127 {

  public int solution(String[] want, int[] number, String[] discount) {
    int answer = 0;

    ArrayList<String> wantList = new ArrayList<>();
    Collections.addAll(wantList, want);

    int[] buy = new int[want.length];
    int count = 0;

    for (int i = 0; i < 10; i++) {
      if (wantList.contains(discount[i])) {
        buy[wantList.indexOf(discount[i])] += 1;
        count++;
      }
    }
    if (isCheck(buy, number)) {
      answer++;
    }



    for (int i = 10; i < discount.length; i++) {
      String item = discount[i];

      int firstItemIdx = i - 10;
      if (!wantList.contains(item)) { //1. 이번 할인이 할인 제품이 아닐 때
        if (wantList.contains(discount[firstItemIdx])) { //이번에 삭제할 아이템이 할인제품일 때
          buy[wantList.indexOf(discount[firstItemIdx])] -= 1;
          count--;
        }
      } else {// 2. 할인제품일 때
        if (wantList.contains(discount[firstItemIdx])) { //이번에 삭제할 아이템이 할인제품일 때
          buy[wantList.indexOf(discount[firstItemIdx])] -= 1;
          count--;
        }
        buy[wantList.indexOf(item)] += 1;
        count++;
      }

      if (count == 10 && isCheck(buy, number)) { //10제품 모두 구매를 원하는 제품일 때
        answer++;
      }
    }

    return answer;
  }

  private boolean isCheck(int[] buy, int[] number) {
    for (int j = 0; j < buy.length; j++) { //want 상품들을 모두 구매했는지 체크
      if (buy[j] < number[j]) {
        return false;
      }
    }
    return true;
  }
}
