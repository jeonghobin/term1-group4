package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Swea_5656 {

    static int N, R, C, min;
    static int[][] data, map;
    static boolean[][] v;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};


    public static class Pair{
        int x, y, level;
        public Pair(int x, int y, int level) {
            super();
            this.x = x;
            this.y = y;
            this.level = level;
        }
    }


    public static int find(int y) {
        for (int i = 0; i < R; i++) {
            if(map[i][y] > 0) return i;
        }
        return -1;
    }
    public static void copy() {
        for (int i = 0; i < R; i++) map[i] = Arrays.copyOf(data[i], C);
    }

    public static void bfs(int a, int b) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(a, b, map[a][b]));

        v[a][b] = true;
        while(!q.isEmpty()) {
            Pair t = q.poll();
            int x = t.x;
            int y = t.y;
            map[x][y] = 0;
            if (t.level <= 1) continue;

            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                for (int j = 0; j < t.level - 1; j++) {
                    int nx = xx + dx[i] * j;
                    int ny = yy + dy[i] * j;
                    if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                    if(v[nx][ny]) continue;
                    v[nx][ny] = true;
                    q.add(new Pair(nx, ny, map[nx][ny]));
                    map[nx][ny] = 0;
                }
            }
        }
    }

    public static void down(int y) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = R - 1; i > - 1; i--) {
            if (map[i][y] > 0) q.add(map[i][y]);
            map[i][y] = 0;
        }
        int size = q.size();
        for (int i = R - 1; i > R - 1 - size; i--) {
            map[i][y] = q.poll();
        }
    }


    public static void recursive(int cnt, int[] sel) {

        if (cnt >= N) {
            copy(); // map에 data를 복사
            for (int i = 0; i < cnt; i++) {
                int x = find(sel[i]);
                if (x == -1) return;
                int y = sel[i];
                if(map[x][y] == 0) return;
                v = new boolean[R][C];
                bfs(x, y);
                // 벽돌 떨구는 코드 , 개수 찾는 코드
                if(count() <= 0) {
                    min = 0;
                    return;
                }
                for (int j = 0; j < C; j++) down(j);
            }
            min = Math.min(min, count());
            return;
        }
        for (int i = 0; i < C; i++) {
            sel[cnt] = i;
            recursive(cnt + 1, sel);
        }
    }
    public static int count(){
        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tc = Integer.parseInt(st.nextToken());

        for (int t = 1; t < tc + 1 ; t++) {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());

            data = new int[R][C];
            map = new int[R][C];
            v = new boolean[R][C];

            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < C; j++) {
                    data[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            min = Integer.MAX_VALUE;
            recursive(0, new int[N]);
            sb.append(min).append("\n");
        }
        System.out.println(sb);
    }

}
