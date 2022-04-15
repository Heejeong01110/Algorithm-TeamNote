package com.example.programmers;

//가장 긴 팰린드롬
public class s12904 {

  public static int solution(String s) {
    int answer = 0;
    char[] strAry = s.toCharArray();

    for (int i = 0; i < s.length() - 1; i++) {
      for (int j = s.length() - 1; j > i; j--) {
        if (j - i < answer) {
          break;
        }

        if (strAry[i] == strAry[j] && isPalindrome(strAry, i, j)) {
          answer = Math.max(answer, j - i);
          break;
        }
      }
    }

    return answer + 1;
  }

  private static boolean isPalindrome(char[] str, int start, int end) {
    int range = (end + 1 - start) / 2;
    for (int i = 0; i < range; i++) {
      if (str[start + i] != str[end - i]) {
        return false;
      }
    }
    return true;
  }
}
