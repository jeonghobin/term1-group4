package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_7733 {

    static int[][] data;
    static boolean[][] v;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int N, max;

    public static void count(int day) {

        int cnt = 0;
        v = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (data[i][j] > day && !v[i][j]) {
                    v[i][j] = true;
                    recursive(i, j, day);
                    cnt++;
                }
            }
        }
        max = Math.max(max, cnt);

    }

    public static void recursive(int x, int y, int day) {


        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (!v[nx][ny] && data[nx][ny] > day) {
                    v[nx][ny] = true;
                    recursive(nx, ny, day);
                }
            }
        }


    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(st.nextToken());

        for (int t = 1; t < tc + 1; t++) {
            sb.append("#").append(t).append(" ");
            N = Integer.parseInt(br.readLine());
            data = new int[N][N];

            int order = -1;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    data[i][j] = Integer.parseInt(st.nextToken());
                    order = Math.max(order, data[i][j]);
                }
            }
            max = -1;
            for (int i = 0; i < order + 1; i++) {
                count(i);
            }
            sb.append(max).append("\n");

        }
        System.out.println(sb);
    }

}