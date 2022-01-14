import java.io.*;
import java.util.*;

public class q13305 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer N = Integer.parseInt(br.readLine()); //도시의 갯수

        long[] price = new long[N];
        long[] distance = new long[N-1];
        //ArrayList<ArrayList<Integer>> city = new ArrayList<>(); //get(i).get(0) :기름 가격, get(i).get(1) :거리
        //ArrayList<Integer> cityList = new ArrayList<Integer>(); //도시 순서 저장
        //초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N-1;i++){
            distance[i] = Integer.valueOf(st.nextToken());
            //city.add(new ArrayList<>());
            //city.get(i).add(Integer.parseInt(st.nextToken()));
        }
        //city.add(new ArrayList<>());
        //city.get(N-1).add(0); 

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            price[i] = Integer.valueOf(st.nextToken());
            //city.get(i).add(Integer.parseInt(st.nextToken()));
            //cityList.add(city.get(i).get(1));
        }

        // 5 ----- 2 ----- 4 ----- 1 < 기름 가격     
        //     2       3       1     < 도시 사이 거리
        //get(i).get(1) :기름 가격, get(i).get(0) :거리
        long result = 0;
        //long minPrice = city.get(0).get(1);
        long minPrice = price[0];
        for(int i=0;i<N-1;i++){
            if(minPrice > price[i]){
                //현재 주유소가 더 싼 경우
                minPrice = price[i];
            }
            result+= minPrice * distance[i];
        }

        bw.write(result+"\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
