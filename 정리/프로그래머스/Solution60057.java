import java.io.*;
import java.util.*;

public class Solution60057 {
    public static void main(String[] args) throws IOException {
        String s = "ababcdcdababcdcd";
        int answer = s.length();

        Integer len;
        for (int i = 1; i < (s.length() / 2) + 1; i++) { // 전체 글자의 절반이 최대 반복 횟수이기 때문에 /2, 1을 고려해서 +1
            len = recursion(s, i).length();
            answer = Math.min(answer, len);
        }

        System.out.println(answer);
    }

    private static String recursion(String remainStr, Integer strLength) {
        if (remainStr.length() <= strLength) {
            return remainStr;
        }

        String replyStr = remainStr.substring(0, strLength);
        remainStr = remainStr.substring(strLength, remainStr.length());
        Integer count = 1;

        while (remainStr.length() > 0) {
            if (!remainStr.startsWith(replyStr)) {
                break;
            }

            count++;
            remainStr = remainStr.substring(strLength, remainStr.length());
        }

        if (count == 1) {
            return replyStr + recursion(remainStr, strLength);
        }
        return count + replyStr + recursion(remainStr, strLength);
    }

}
