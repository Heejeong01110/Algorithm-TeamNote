import java.io.*;
import java.util.*;

public class q1260 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer N; //정점의 갯수
        Integer M; //간선의 갯수
        Integer V; //탐색 시작 번호


        String a[] = br.readLine().split(" ");
        N = Integer.parseInt(a[0]);
        M = Integer.parseInt(a[1]);
        V = Integer.parseInt(a[2]);

        String b[] = new String[2];
        
        Integer[][] graph = new Integer[N+1][N+1];
        boolean[] dfscheck = new boolean[N+1];
        boolean[] bfscheck = new boolean[N+1];
        ArrayList<Integer> dfsresult = new ArrayList<>();
        ArrayList<Integer> bfsresult = new ArrayList<>();

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                graph[i][j] = 0;
            }
            dfscheck[i] = false;
            bfscheck[i] = false;
        }

        dfscheck[V] = true;
        bfscheck[V] = true;
        dfsresult.add(V);
        bfsresult.add(V);

        for(int i=1;i<=M;i++){
            b = br.readLine().split(" ");
            
            graph[Integer.parseInt(b[0])][Integer.parseInt(b[1])] = 1;
            graph[Integer.parseInt(b[1])][Integer.parseInt(b[0])] = 1;

        }

        dfs(V,graph,N,dfscheck,dfsresult);
        bfs(V,graph,N,bfscheck,bfsresult);


        for(int i=0;i<dfsresult.size();i++){
            bw.write(dfsresult.get(i)+" "); //dfs
        }
        bw.write("\n");
        for(int i=0;i<bfsresult.size();i++){
            bw.write(bfsresult.get(i)+" "); //bfs
        }


        br.close();
        bw.flush();
        bw.close();
    }

    static void dfs(Integer start, Integer[][] graph, int N, boolean[] check, ArrayList<Integer> result){
        
        if(result.size() == N){
            return;
        }
        
        for(int i=1;i<=N;i++){
            if(graph[start][i]==1&&check[i]==false){
                check[i]=true;
                result.add(i);
                dfs(i,graph,N,check,result);
            }
        }
    }

    static void bfs(Integer start, Integer[][] graph, int N, boolean[] check, ArrayList<Integer> result){
        
        int K=start;
        int temp = 0; // result 앞부터 순차적으로 확인
        int j=1;
        while(true){
            if(graph[K][j]==1&&check[j]==false){
                result.add(j);
                check[j]=true;
            }
            
            if(j==N){
                if(temp+1 == result.size()){
                    return;
                }
                j=0;
                K = result.get(++temp);
            }
            j++;
        }
        
    }


}

/*
    dfs : depth-first-search 깊이 우선탐색
    bfs : breadth-first-search 너비 우선 탐색
*/