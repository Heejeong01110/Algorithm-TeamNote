import java.io.*;
import java.util.*;

public class q2504 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        Stack<int[]> stack = new Stack<>();
        Stack<Integer> sumstack = new Stack<>();
        int depth = 0;
        boolean flag = true;
        int result = 1;

        for (int i = 0; i < str.length(); i++) {
            int[] array = new int[2];
            if (str.charAt(i) == '(') {
                array[0] = 2;
                array[1] = ++depth;
                stack.add(array);
                flag = true;
            } else if (str.charAt(i) == '[') {
                array[0] = 3;
                array[1] = ++depth;
                stack.add(array);
                flag = true;
            } else if (str.charAt(i) == ')') {
                array = stack.pop();
                if (array[0] == 2 && array[1] == depth--) {
                    if (flag) {
                        if(sumstack)
                        sumstack.add(2);
                    } else {
                        if (!sumstack.isEmpty()) {
                            sumstack.add(sumstack.pop() * 2);
                        } else {
                            System.out.println("0");
                            return;
                        }
                    }
                } else {
                    System.out.println("0");
                    return;
                }

                flag = false;
            } else if (str.charAt(i) == ']') {
                array = stack.pop();
                if (array[0] == 3 && array[1] == depth--) {
                    if (flag) {
                        sumstack.add(3);
                    } else {
                        if (!sumstack.isEmpty()) {
                            sumstack.add(sumstack.pop() * 3);
                        } else {
                            System.out.println("0");
                            return;
                        }
                    }
                } else {
                    System.out.println("0");
                    return;
                }

                flag = false;
            }
        }
        
        while (!sumstack.isEmpty()) {
            result += sumstack.pop();
        }

        System.out.println(result);
        br.close();
    }


}
