package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2146 {

    static int[][] data, map;
    static boolean[][] v, vv;
    static int cnt, N, min;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static class Position{
        int x, y, depth;
        public Position(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
        public Position(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }


    public static void bfs(int x, int y) {
        Queue<Position> q = new ArrayDeque<Position>();
        q.add(new Position(x, y));
        map[x][y] = cnt;
        v[x][y] = true;
        while(!q.isEmpty()) {
            Position p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if(map[nx][ny] == 1 && !v[nx][ny]) {
                        v[nx][ny] = true;
                        map[nx][ny] = cnt;
                        q.add(new Position(nx, ny));
                    }
                }
            }
        }
    }

    public static boolean check(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (map[nx][ny] == 0) return true;
            }
        }
        return false;
    }


    public static void bbfs(int x, int y) {

        Queue<Position> q = new ArrayDeque<Position>();
        q.add(new Position(x, y, 0));
        v[x][y] = true;

        while(!q.isEmpty()) {
            Position b = q.poll();
//            v[b.x][b.y] = true;
//            System.out.println(b.x + " " + b.y + " " + min);
            for (int i = 0; i < 4; i++) {
                int nx = b.x + dx[i];
                int ny = b.y + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if(map[nx][ny] == 0 && !v[nx][ny]) {
                        v[nx][ny] = true;
                        q.add(new Position(nx, ny, b.depth + 1));
                    }else if(map[nx][ny] != map[x][y] && map[nx][ny] != 0) {
                        min = Math.min(min, b.depth);
                        break;
                    }
                }
            }

        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        v = new boolean[N][N];
        min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cnt = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !v[i][j]) {
                    bfs(i, j);
                    cnt++;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            Arrays.fill(v[i], false);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] != 0 && check(i, j)) {
                    bbfs(i, j);
                }
                for (int k = 0; k < N; k++) {
                    Arrays.fill(v[k], false);
                }
            }
        }
        System.out.println(min);

    }
}
