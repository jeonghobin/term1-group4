package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1012 {

    static int[][] data;
    static int N, M;
    static boolean[][] v;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static class Pair{

        int x, y;

        public Pair(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs(int x, int y) {

        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(x, y));
        v[x][y] = true;

        while(!q.isEmpty()) {

            Pair p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!v[nx][ny] && data[nx][ny] == 1) {
                        data[nx][ny] = 0;
                        v[nx][ny] = true;
                        q.offer(new Pair(nx,ny));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            data = new int[N][M];
            v = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                data[x][y] = 1;
            }
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (data[i][j] == 1) {
                        bfs(i,j);
                        cnt ++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}
