package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Swea_1949 {
    static int N, K, dis;
    static int[][] data;
    static boolean[][] v;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static boolean flag;
    static ArrayList<Pair> p;

    public static class Pair{
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    public static void dfs(int x, int y, int cnt){

        dis = Math.max(dis, cnt);
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < N && ny >= 0 && ny < N){
                if (v[nx][ny]) continue;
                v[nx][ny] = true;
                if(data[nx][ny] < data[x][y]) dfs(nx, ny, cnt + 1);
                if(data[nx][ny] >= data[x][y] && !flag){
                    flag = true;
                    for (int j = 1; j <= K; j++) {
                        data[nx][ny] -= j;
                        if(data[nx][ny] < data[x][y]) dfs(nx, ny, cnt + 1);
                        data[nx][ny] += j;
                    }
                    flag = false;
                }
                v[nx][ny] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int t = 1; t < tc + 1; t++) {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            data = new int[N][N];
            v = new boolean[N][N];
            p = new ArrayList<>();

            int max = -1;
            dis =  - 1;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    data[i][j] = Integer.parseInt(st.nextToken());
                    if(data[i][j] > max) {
                        p.clear();
                        max = data[i][j];
                        p.add(new Pair(i, j));
                    }
                    else if(data[i][j] == max){
                        p.add(new Pair(i, j));
                    }
                }
            }
            for (int i = 0; i < p.size(); i++) {
                Pair tt = p.get(i);
                v[tt.x][tt.y] = true;
                dfs(tt.x, tt.y, 1);
                v[tt.x][tt.y] = false;
            }
            sb.append(dis).append("\n");
        }
        System.out.println(sb);
    }
}

