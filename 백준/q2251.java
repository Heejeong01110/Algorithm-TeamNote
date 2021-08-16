import java.io.*;
import java.util.*;

public class q2251 {
    static boolean[][] visited = new boolean[201][201];
    static boolean[] ans = new boolean[201];
    static int a, b, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        a = A;
        b = B;
        c = C;

        ArrayList<int[]> memory = new ArrayList<>();

        int[] current = new int[3];
        current[0] = 0;
        current[1] = 0;
        current[2] = C;

        /*
        dfs(A, B, C, current, memory);
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < memory.size(); i++) {
            if (!result.contains(memory.get(i)[2])) {
                result.add(memory.get(i)[2]);
            }
        }
        
        Collections.sort(result);
        
        for (int i = 1; i < result.size(); i++) {
            bw.write(result.get(i)+" ");
        }*/
        dfs(0, 0, c);

        for (int i = 0; i < 201; i++) {
            if (ans[i]) {
                System.out.print(i + " ");
            }
        }


        bw.write("\n");

        br.close();
        bw.flush();
        bw.close();
    }
/*
static void dfs(int A, int B, int C, int[] current, ArrayList<int[]> memory) {
    
    boolean temp = false;
    for (int i = 0; i < memory.size(); i++){
        if(memory.get(i)[0] == current[0] && memory.get(i)[1] == current[1] && memory.get(i)[2] == current[2]){
            temp = true;
            break;
        }
    }

    if (temp) {
        return;
    }

    memory.add(current);
    if (current[0] != 0) {
        // A -> B
        int[] item = new int[3];
        item[0] = (B - current[1]) > (current[0]) ? 0 : current[0] - (B - current[1]);
        item[1] = (B - current[1]) > (current[0]) ? current[1] + (current[0]) : B;
        item[2] = current[2];
        dfs(A, B, C, item, memory);

        // A -> C
        item = new int[3];
        item[0] = (C - current[2]) > (current[0]) ? 0 : current[0] - (C - current[2]);
        item[1] = current[1];
        item[2] = (C - current[2]) > (current[0]) ? current[2] + (current[0]) : C;
        dfs(A, B, C, item, memory);

    }
    
    if (current[1] != 0) {
        //B -> A
        int[] item = new int[3];
        item[0] = (A - current[0]) > (current[1]) ? current[0] + (current[1]) : A;
        item[1] = (A - current[0]) > (current[1]) ? 0 : current[1] - (A - current[0]);
        item[2] = current[2];
        dfs(A, B, C, item, memory);
        
        // B -> C
        item[0] = current[0];
        item[1] = (C - current[2]) > (current[1]) ? 0 : current[1] - (C - current[2]);
        item[2] = (C - current[2]) > (current[1]) ? current[2] + (current[1]) : C;
        dfs(A, B, C, item, memory);
    }
    
    if (current[2] !=0) {
        //C -> A
        
        int[] item = new int[3];
        item[0] = (A - current[0]) > (current[2]) ? current[0] + (current[2]) : A;
        item[1] = current[1];
        item[2] = (A - current[0]) > (current[2]) ? 0 : current[2] - (A - current[0]);
        dfs(A, B, C, item, memory);

        //C -> B
        item[0] = current[0];
        item[1] = (B - current[1]) > (current[2]) ? current[1] + (current[2]) : B;
        item[2] = (B - current[1]) > (current[2]) ? 0 : current[2] - (B - current[1]);
        dfs(A, B, C, item, memory);
    }

}
*/
    public static void dfs(int ca, int cb, int cc) {
    if (visited[ca][cb]) {
        return;
    } 
 
    if (ca == 0) {
        ans[cc] = true;
    }
 
    visited[ca][cb] = true;
 
    // a -> b
    if (ca + cb > b) {
        dfs((ca + cb) - b, b, cc);
    } else {
        dfs(0, ca + cb, cc);
    }
    // b -> a
    if (cb + ca > a) {
        dfs(a, (cb + ca) - a, cc);
    } else {
        dfs(cb + ca, 0, cc);
    }
    // c -> a
    if (cc + ca > a) {
        dfs(a, cb, (cc + ca) - a);
    } else {
        dfs(cc + ca, cb, 0);
    }
    // c -> b
    if (cc + cb > b) {
        dfs(ca, b, (cc + cb) - b);
    } else {
        dfs(ca, cc + cb, 0);
    }
    // b -> c, a -> c
    // a + b = c 이기 때문에, c가 넘칠 일이 없다.
    dfs(ca, 0, cb + cc);
    dfs(0, cb, ca + cc);
}

}
