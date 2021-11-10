import java.io.*;
import java.util.*;

public class Solution42628 {
    public static void main(String[] args) throws IOException {
        ArrayList<String[]> operationss = new ArrayList<>();

        String[] strings1 ={"I 16","D 1"};
        String[] strings2 = { "I 7", "I 5", "I -5", "D -1" };
        String[] strings3 = { "I 7", "I 5", "I -5", "I 3", "D -1" };
        String[] strings4 = { "I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        operationss.add(strings1);
        operationss.add(strings2);
        operationss.add(strings3);
        operationss.add(strings4);

        for (String[] operations : operationss) {
            System.out.println(Arrays.toString(solution(operations)));
        }
    }

    private static int[] solution(String[] operations) {
        int[] answer = {0,0};
        String option;
        String maxMin;

        Deque<Integer> deque = new ArrayDeque<>();

        for (String operation : operations) {
            StringTokenizer st = new StringTokenizer(operation, " ");
            option = st.nextToken();
            switch (option) {
                case "I" -> deque = inputNumber(deque,Integer.parseInt(st.nextToken()));
                case "D" -> {
                    maxMin = st.nextToken();
                    if (maxMin.equals("1")) {
                        deque.pollLast();
                    } else if (maxMin.equals("-1")) {
                        deque.pollFirst();
                    }

                }
            }
        }
        if (deque.size() >= 1) {
            answer[0] = deque.peekLast();
            answer[1] = deque.peekFirst();
        } else {
            answer[0] = 0;
            answer[1] = 0;
        }
        return answer;
    }

    private static Deque<Integer> inputNumber(Deque<Integer> deque, Integer number) {
        Deque<Integer> result = new ArrayDeque<>();
        Integer peek = 0;
        if (deque.isEmpty()) {
            result.add(number);
            return result;
        }

        while (!deque.isEmpty()) {
            peek = deque.pollFirst();
            if (peek < number) {
                result.addLast(peek);
            } else {
                result.addLast(number);
                result.addLast(peek);
                break;
            }
        }

        if (!result.contains(number)) {
            result.addLast(number);
        }
        

        while (!deque.isEmpty()) {
            result.addLast(deque.pollFirst());
        }

        return result;
    }
}