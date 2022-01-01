import java.io.*;
import java.util.*;

public class Solution60057 {
    public static void main(String[] args) throws IOException {
        String s = "xababcdcdababcdcd";
        int answer = s.length();
        
        Integer length = s.length();
        String changeStr;
        while (length > 0) {
            changeStr = findReply(s, length);
            answer = Math.min(answer, changeStr.length());
            length--;
        }


        System.out.println(answer);
    }

    private static String findReply(String s, Integer length) {
        Integer count = 1;
        String replyStr = "";
        String remainStr = s;
        String returnStr = "";
        while (true) {
            if (replyStr.length() == 0) {
                replyStr = remainStr.substring(0, length);
                remainStr = remainStr.substring(length, s.length());
                count = 1;

            } else if (replyStr.length() > remainStr.length()) {
                if (count > 1) {
                    returnStr += count + replyStr;
                } else {
                    returnStr += replyStr;
                }
                returnStr += remainStr;
                return returnStr;

            } else if (replyStr.equals(remainStr.substring(0, length))) {
                remainStr = remainStr.substring(length, remainStr.length());
                count++; // 계속 검사
            } else {
                if (count > 1) {
                    returnStr += count + replyStr;
                } else {
                    returnStr += replyStr;
                }
                replyStr = remainStr.substring(0, length);
                remainStr = remainStr.substring(length, remainStr.length());
                count = 1;
            }

            // System.out.println(" 반복중 : " + replyStr + " , " + remainStr);
            if (remainStr.length() <= 0) {
                if (count > 1) {
                    returnStr += count + replyStr;
                } else {
                    returnStr += replyStr;
                }
                returnStr += remainStr;
                // System.out.println("최종 : " + returnStr);
                return returnStr;
            }

        }
    }

}
