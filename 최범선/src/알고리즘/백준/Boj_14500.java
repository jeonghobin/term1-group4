package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14500 {

    static int R, C, rsl;
    static int[][] data;
    static boolean[][] v;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};


    public static void dfs(int x, int y, int cnt, int d, int sum) {

        if (cnt >= 4) {
            rsl = Math.max(rsl, sum);
            return;
        }

        if (d > -1 && d < 4 && cnt >= 3) {
            v[x-dx[d]][y-dy[d]] = false;
            dfs(x - dx[d], y - dy[d], cnt, -1, sum);
            v[x-dx[d]][y-dy[d]] = true;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= R || ny < 0 || ny >= C || v[nx][ny]) continue;
            v[nx][ny] = true;
            if (cnt == 1) d = i;
            dfs(nx, ny, cnt + 1, d == i ? d : -1 ,sum + data[nx][ny]);
            v[nx][ny] = false;
        }

    }



    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        data = new int[R][C];
        v = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        rsl = -1;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                v[i][j] = true;
                dfs(i, j, 1, 4, data[i][j]);
                v[i][j] = false;
            }
        }
        System.out.println(rsl);
    }

}