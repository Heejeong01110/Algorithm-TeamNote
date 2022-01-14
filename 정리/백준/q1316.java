import java.io.*;
import java.util.ArrayList;

public class q1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Integer sum = 0;
        Integer N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            boolean flag = true;
            ArrayList<Character> ary = new ArrayList<>();
            for (int j = 0; j < str.length(); j++) {
                if (!ary.contains(str.charAt(j))) {
                    ary.add(str.charAt(j));
                } else if(ary.get(ary.size()-1).equals(str.charAt(j))){
                } else {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                sum += 1;
            }
        }


        bw.write(sum+"\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
