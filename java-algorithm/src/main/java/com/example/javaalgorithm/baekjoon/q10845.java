import java.io.*;

public class q10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String str;
        String[] cmd = new String[2];

        int[] queue = new int[N];
        int queuef = -1; // 입력된 맨 앞 index -1를 가리킴
        int queueb = -1; // 입력된 맨 뒤 index를 가리킴

        for (int i = 0; i < N; i++) {
            str = br.readLine();
            cmd = str.split("\\s");
            switch (cmd[0]) {
                case "push":
                    queue[++queueb] = Integer.parseInt(cmd[1]);
                    break;
                case "pop":
                    if (queuef >= queueb) { // 비어있을 경우
                        bw.write("-1\n");
                    } else {
                        bw.write(queue[++queuef] + "\n");
                    }
                    break;
                case "size":
                    bw.write((queueb - queuef) + "\n");
                    break;
                case "empty":
                    if (queuef >= queueb) { // 비어있을 경우
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                case "front":
                    if (queuef >= queueb) { // 비어있을 경우
                        bw.write("-1\n");
                    } else {
                        bw.write(queue[queuef + 1] + "\n");
                    }
                    break;
                case "back":
                    if (queuef >= queueb) { // 비어있을 경우
                        bw.write("-1\n");
                    } else {
                        bw.write(queue[queueb] + "\n");
                    }
                    break;
                default:
                    break;
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
