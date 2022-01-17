package com.example.baekjoon;

import java.io.*;
import java.util.*;

public class q13022 {

  private static String word;
  private static Character[] wordList = {'w', 'o', 'l', 'f'};

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    output(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    word = br.readLine();
    br.close();
  }

  private static Integer Solution(){
    int index = 0;
    while(index < word.length()){
      if(word.charAt(index) == wordList[0]){
        index = checkCorrect(index);
      }else{
        return 0;
      }

      if(index == -1){
        return 0;
      }
      index++;
    }

    return 1;
  }

  private static int checkCorrect(int start){
    int count = 0; // w 반복 횟수

    for(int i=start;i<word.length();i++){
      if(word.charAt(i) == wordList[0]){
        count += 1;
      }else{
        break;
      }
    }

    StringBuilder correctWord = new StringBuilder();
    for (Character character : wordList) {
      correctWord.append(String.valueOf(character).repeat(count));
    }

    if(start + count*4 > word.length()){
      return -1;
    }


    if(word.substring(start, start + count*4).equals(correctWord.toString())){
      return start + count*4 -1;
    }

    return -1;
  }

  private static void output(Integer result) {
    System.out.print(result);
  }

}
