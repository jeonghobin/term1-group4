package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_7576 {

    static int[][] data;
    static Queue<Pair> q;
    static int N, M , cnt;
    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};
    static boolean[][] v;
    public static class Pair{
        int x, y, day;

        public Pair(int x, int y, int day) {
            super();
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    public static void bfs() {

        while (!q.isEmpty()) {

            Pair p = q.poll();
            v[p.x][p.y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if(!v[nx][ny] && data[nx][ny] == 0) {
                        v[nx][ny] = true;
                        data[nx][ny] = 1;
                        q.offer(new Pair(nx, ny, p.day + 1));
                        cnt = Math.max(cnt, p.day + 1);
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        data = new int[N][M];
        v = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        q = new LinkedList<>();
        cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (data[i][j] == 1) {
                    q.offer(new Pair(i,j,0));
                }
            }
        }
        bfs();
        boolean flag = true;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (data[i][j] == 0) flag = false;
            }
        }
        System.out.println(flag ? cnt : -1);

    }
}
