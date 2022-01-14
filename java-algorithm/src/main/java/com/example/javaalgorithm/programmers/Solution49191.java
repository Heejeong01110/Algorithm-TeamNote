import java.io.*;
import java.util.*;

public class Solution49191 {
    public static void main(String[] args) throws IOException {
        int n = 5;
        int[][] results = { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } };
        int answer = 0;

        // HashMap<Integer, Integer[][]> map = new HashMap<>();

        // for (int i = 1; i <= n; i++) {
        //     Integer[][] array = new Integer[2][n + 1];

        //     // 자기 자신
        //     array[0][i] = 0;
        //     array[1][i] = 0;

        //     map.put(i, array);
        //     // Integer[0][n] : i가 진 선수
        //     // Integer[1][n] : i가 승리한 선수
        // }

        // for (int i = 0; i < results.length; i++) {
        //     map.get(results[i][0])[1][results[i][1]] = 1; //4번선수가 3번선수를 이김
        //     map.get(results[i][1])[0][results[i][0]] = 1;// 3번선수가 4번선수에게 짐
        //     //3번선수가 이긴 목록은 4번선수도 이김
        //     //4번 선수가 진 목록은 3번선수도 짐
        //     for (int j = 1; j <= n; j++) {
        //         if (map.get(results[i][1])[1][j] != null) {
        //             map.get(results[i][0])[1][j] = 1;
        //         }
        //         if (map.get(results[i][0])[0][j] != null) {
        //             map.get(results[i][1])[0][j] = 1;
        //         }
        //     }
        // }

        // for (int i = 1; i <= n; i++) {
        //     System.out.println("\n"+i);

        //     System.out.print("승리 : ");
        //     for (int j = 1; j <= n; j++) {
        //         if (map.get(i)[1][j] != null) {
        //             System.out.print(j + ", ");
        //         }
        //     }

        //     System.out.print("\n패배 : ");
        //     for (int j = 1; j <= n; j++) {
        //         if (map.get(i)[0][j] != null) {
        //             System.out.print(j + ", ");
        //         }
        //     }
        // }

        // for (int i = 1; i <= n; i++) {

        //     Integer count = 0;
        //     for (int m = 0; m < 2; m++) {
        //         for (int j = 1; j <= n; j++) {
        //             if (map.get(i)[m][j] != null && map.get(i)[m][j] != i) {
        //                 count += 1;
        //             }
        //         }
        //     }

        //     if (count == n - 1) {
        //         answer += 1;
        //     }
        // }

        //int[][] results = { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } };
        int[][] vsmap = new int[n+1][n+1];

        for (int i = 0; i < results.length; i++) {
            vsmap[results[i][0]][results[i][1]] = 1;
            // vsmap[results[i][1]][results[i][0]] = 2;

            // //4번 선수가 진 목록은 3번선수도 짐
            // for (int j = 1; j <= n; j++) {
            //     if (vsmap[results[i][0]][j] == 2) {
            //         vsmap[results[i][1]][j] = 2;
            //     }
            // }

            // 3번선수가 이긴 목록은 4번선수도 이김
            for (int j = 1; j <= n; j++) {
                if (vsmap[results[i][1]][j] == 1) {
                    vsmap[results[i][0]][j] = 1;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    
                    if(vsmap[i][j])








                }
            }
            

            for (int j = 0; j < n; j++) {
                if (vsmap[i][j] == 1) {
                    vsmap[i][j] = 1;
                }
            }
        }


        for (int i = 1; i <= n; i++) {
            Integer count = 0;
            for (int j = 1; j <= n; j++) {
                if (i != j && vsmap[i][j] != 0) {
                    count += 1;
                }
            }
            
            if (count == n - 1)
                answer += 1;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(vsmap[i][j]+" ");
            }
            System.out.println(" ");
        }

        System.out.println("\n" + answer);
    }
}
