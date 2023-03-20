package com.example.programmers;

public class s150367 {

  public int[] solution(long[] numbers) {
    int[] answer = new int[numbers.length];

    //해당 수를 이진트리로 나타냈을 때, 이진 트리의 루트 자리에서부터 이어진 형태인지 확인해야 함.
    for (int i = 0; i < numbers.length; i++) {
      long temp = numbers[i];
      String str = Long.toBinaryString(numbers[i]);
      int j = 0;
      while ((int) Math.pow(2, j) - 1 < str.length()) {
        j++;
      }
      while ((int) Math.pow(2, j) - 1 != str.length()) {
        str = "0" + str;
      }
      if(dfs(str)) {
        answer[i] = 1;
      }
    }

    return answer;
  }

  private static boolean dfs(String number) {
    boolean valid = true;

    int mid = (number.length()-1)/2;
    char root = number.charAt(mid);
    String left = number.substring(0,mid);
    String right = number.substring(mid+1);

    if(root == '0' && (left.charAt((left.length()-1)/2)=='1' || right.charAt((right.length()-1)/2)=='1')){
      return false;
    }

    if(left.length() >= 3) {
      valid = dfs(left);
      if(valid) {
        valid = dfs(right);
      }
    }
    return valid;
  }


}
