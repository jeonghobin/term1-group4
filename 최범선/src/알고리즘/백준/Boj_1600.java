package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1600 {

    static int K, R, C, count;
    static int[][] data;
    static int[][][] v;
    static int[] dx = { 0, 1, 0, -1 }, ddx = { 1, 1, -1, -1, 2, 2, -2, -2 };
    static int[] dy = { 1, 0, -1, 0 }, ddy = { 2, -2, 2, -2, 1, -1, 1, -1 };;


    static class Pair {
        int x, y, cnt, flag;

        public Pair(int x, int y, int cnt, int flag) {
            super();
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.flag = flag;
        }
    }

    public static void bfs() {

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, 0, 0));

        while (!q.isEmpty()) {

            Pair t = q.poll();
            int x = t.x;
            int y = t.y;
            int cnt = t.cnt;
            int flag = t.flag;
//			System.out.println(x + " " + y);
            if (x == R - 1 && y == C - 1) {
                count = cnt;
                return;
            }
            if (flag < K) {
                for (int i = 0; i < 8; i++) {
                    int nx = x + ddx[i];
                    int ny = y + ddy[i];
                    if (nx < 0 || nx >= R || ny < 0 || ny >= C || data[nx][ny] == 1) continue;
                    if (v[nx][ny][flag + 1] > 0) continue;
                    v[nx][ny][flag + 1] = cnt + 1;
                    q.add(new Pair(nx, ny, cnt + 1, flag+1));
                }
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= R || ny < 0 || ny >= C || data[nx][ny] == 1) continue;
                if(v[nx][ny][flag] > 0) continue;
                v[nx][ny][flag] = cnt + 1;
                q.add(new Pair(nx, ny, cnt + 1, flag));
            }
//			print();
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        data = new int[R][C];
        v = new int[R][C][K + 1];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        count = -1;
        bfs();
        System.out.println(count);

    }

    static void print() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
