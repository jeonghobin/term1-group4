package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_11660 {

    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] data = new int[N + 1][N + 1];
        int[][] sum = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int temp = 0;
            for (int j = 1; j < N + 1; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
                temp += data[i][j];
                if(i-1 >= 0) {
                    sum[i][j] = sum[i-1][j] + temp;
                }else {
                    sum[i][j] = temp;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int temp = sum[x2][y2] - (sum[x1 - 1][y2] + sum[x2][y1-1]) + sum[x1-1][y1-1];
            sb.append(temp).append("\n");
        }
        System.out.println(sb);
    }
}