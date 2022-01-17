package com.example.baekjoon;

import java.io.*;
import java.util.*;

public class q {

    private static Integer N;
    private static Integer M;

    public static void main(String[] args) throws IOException {
        inputData();
    }

    private static void inputData() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        br.close();
    }

}
