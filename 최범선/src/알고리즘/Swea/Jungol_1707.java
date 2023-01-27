package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Jungol_1707 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] data = new int[N][N];

        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        int cnt = 1;
        int x = 0, y = 0, idx = 0;

        while (cnt <= N * N) {

            data[x][y] = cnt;

            int nx = x + dx[idx];
            int ny = y + dy[idx];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (data[nx][ny] != 0) {
                    idx++;
                    if (idx >= 4) idx = 0;
                    nx = x + dx[idx];
                    ny = y + dy[idx];
                }
                x = nx;
                y = ny;
            }else {
                idx++;
                if (idx >= 4) idx = 0;
                x = x + dx[idx];
                y = y + dy[idx];
            }
            cnt++;
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }
}
