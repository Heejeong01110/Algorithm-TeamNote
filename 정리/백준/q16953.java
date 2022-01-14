import java.io.*;
import java.util.StringTokenizer;

public class q16953 {
    static int result = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());

        int depth = 0;

        while (A <= B) {
            if (A == B) {
                result = depth+1;
                break;
            }


            if (B % 10 == 1) {
                B /= 10;
            } else if (B % 2 == 0) {
                B /= 2;
            } else {
                result = -1;
                break;
            }

            depth += 1;
        }

        bw.write(result + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
    
    static void dfs(long A, long B, int depth) {
        if (A > B) {
            return;
        }
        if (A == B) {
            result = depth + 1;
            return;
        }


        dfs(A*2, B, depth+1);
        dfs(A*10+1, B, depth+1);
        


        return;
    }

}
