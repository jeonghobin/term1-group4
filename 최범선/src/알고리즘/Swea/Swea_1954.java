package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Swea_1954 {

    static int[][] data;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int N;

    public static void recursive(int x, int y, int cnt, int d) {
        if (cnt > N * N) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(data[i][j] + " ");
                }
                System.out.println();
            }
            return;
        }
        data[x][y] = cnt;
        int nx = x + dx[d];
        int ny = y + dy[d];
        if (nx < 0 || nx >= N || ny < 0 || ny >= N || data[nx][ny] != 0) {
            d++;
            d %= 4;
            nx = x + dx[d];
            ny = y + dy[d];
        }

        recursive(nx, ny, cnt + 1, d);
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t < tc + 1; t++) {
            System.out.println("#" + t);
            N = Integer.parseInt(br.readLine());

            data = new int[N][N];

            recursive(0,0,1,0);
        }


    }
}