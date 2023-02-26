package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_10026 {

    static int N;
    static char[][] c;
    static boolean[][] v, vv;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static class Pair{
        int x,y;
        public Pair(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs(int x, int y) {

        Queue<Pair> q = new ArrayDeque<Pair>();
        q.add(new Pair(x,y));
        char start = c[x][y];
        v[x][y] = true;
        while(!q.isEmpty()) {
            Pair p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if(c[nx][ny] == start && !v[nx][ny]) {
                        v[nx][ny] = true;
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }
    }

    public static void bbfs(int x, int y) {
        Queue<Pair> q = new ArrayDeque<Pair>();

        q.add(new Pair(x,y));
        char s = c[x][y];
        vv[x][y] = true;
        while(!q.isEmpty()) {
            Pair p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if(!vv[nx][ny]) {
                        if((c[nx][ny] == 'R' || c[nx][ny] == 'G') && (s == 'R' || s == 'G')) {
                            vv[nx][ny] = true;
                            q.add(new Pair(nx, ny));
                        }else if(c[nx][ny] == s) {
                            vv[nx][ny] = true;
                            q.add(new Pair(nx, ny));
                        }

                    }

                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        c = new char[N][N];
        v = new boolean[N][N];
        vv = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String a = br.readLine();
            for (int j = 0; j < N; j++) {
                c[i][j] = a.charAt(j);
            }
        }
        int a = 0, b = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!v[i][j]) {
                    bfs(i, j);
                    a++;
                }
                if(!vv[i][j]) {
                    bbfs(i, j);
                    b++;
                }
            }
        }


        System.out.println(a + " " + b);

    }
}
