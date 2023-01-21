package 알고리즘;

import java.io.*;
import java.util.*;

public class Boj_1018 {

    static char[][] data;
    static char[] index = {'W' , 'B'};
    static int check(int i, int j) {
        int min = Integer.MAX_VALUE, cnt = 0, start = 0;
        for (int l = i; l < i + 8; l++) {
            for (int k = j; k < j + 8; k++) {
                if (data[l][k] != index[start]) {
                    cnt++;
                }
                if (k < j+7) {
                    start++;
                    start %= 2;
                }
            }
        }
        min = Math.min(min, cnt);
        cnt = 0;
        start = 1;
        for (int l = i; l < i + 8; l++) {
            for (int k = j; k < j + 8; k++) {
                if (data[l][k] != index[start]) {
                    cnt++;
                }
                if (k < j+7) {
                    start++;
                    start %= 2;
                }

            }
        }
        min = Math.min(min, cnt);
        return min;
    }



    public static void main(String args[]) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        data = new char[N][M];

        for (int i = 0; i < N; i++) {
            char[] a = br.readLine().toCharArray();
            for (int j = 0 ; j < M; j++) {
                data[i][j] = a[j];
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                min = Math.min(min, check(i,j));
            }

        }
        System.out.println(min);



    }
}
