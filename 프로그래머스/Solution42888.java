import java.io.*;
import java.util.*;

public class Solution42888 {
    public static void main(String[] args) throws IOException {
        String[] record = {
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan" };

        String[] answer = {};

        HashMap<String, String> noteMap = new HashMap<>();
        noteMap.put("Enter", "님이 들어왔습니다.");
        noteMap.put("Leave", "님이 나갔습니다.");

        HashMap<String, String> uidMap = new HashMap<>();
        ArrayList<String[]> answerString = new ArrayList<>();
        for (String clips : record) {
            String[] clip = clips.split(" ");
            switch (clip[0]) {
                case "Enter" -> {
                    String[] ary = new String[2];
                    uidMap.put(clip[1], clip[2]);
                    ary[0] = clip[0];
                    ary[1] = clip[1];
                    answerString.add(ary);
                }
                case "Leave" -> {
                    String[] ary = new String[2];
                    ary[0] = clip[0];
                    ary[1] = clip[1];
                    answerString.add(ary);
                }
                case "Change" -> {
                    uidMap.put(clip[1], clip[2]);
                }
            }
        }
        answer = new String[answerString.size()];
        for (int i = 0; i < answerString.size(); i++) {
            answer[i] = uidMap.get(answerString.get(i)[1]) + noteMap.get(answerString.get(i)[0]);
        }

        System.out.println(Arrays.toString(answer));
    }

}
