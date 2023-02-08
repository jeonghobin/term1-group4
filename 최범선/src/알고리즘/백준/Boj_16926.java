package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_16926 {

    static int N , M, R , min;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] data;

    public static void rotate() {

        for (int i = 0; i < min; i++) {
            int idx = 0;
            int nx = i + dx[idx];
            int ny = i + dy[idx];
            int before = data[i][i];
            while(true) {
                int temp = data[nx][ny];
                data[nx][ny] = before;
                before = temp;
                if (nx == i && ny == i) break;

                if(nx + dx[idx] < 0 + i || nx + dx[idx] >= N - i || ny + dy[idx] < 0 + i || ny + dy[idx] >= M - i) {
                    idx++;
                    idx %= 4;
                }
                nx += dx[idx];
                ny += dy[idx];
            }
        }
    }

    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        data = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        min = Math.min(N / 2, M / 2);
        for (int i = 0; i < R; i++) {
            rotate();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }

    }
}
