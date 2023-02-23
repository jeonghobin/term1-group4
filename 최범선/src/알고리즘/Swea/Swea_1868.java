package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Swea_1868 {

    static char[][] data;
    static int[][] map;
    static boolean[][] v;
    static int N, cnt;
    static int[] dx = {0,1,0,-1,1,1,-1,-1};
    static int[] dy = {1,0,-1,0,1,-1,-1,1};

    public static class Position{
        int x, y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void bfs(int x, int y){
        Queue<Position> q = new LinkedList<>();
        v = new boolean[N][N];
        q.add(new Position(x, y));
        v[x][y] = true;
        map[x][y] = 1;

        while (!q.isEmpty()){
            Position p = q.poll();
            if (check(p.x, p.y)) map[p.x][p.y] = 1;
            else{
            for (int i = 0; i < 8; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N){
                    if (!v[nx][ny] && data[nx][ny] == '.' ){
                        if (map[nx][ny] > 0 && map[nx][ny] != 9) cnt--;
                        map[nx][ny] = 0;
                        v[nx][ny] = true;
                        if (!check(nx, ny)) q.add(new Position(nx, ny));
                    }
                }
                }
            }
        }
    }
    public static boolean check(int x, int y){
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N){
                if (data[nx][ny] == '*') return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t < tc + 1; t++) {

            sb.append("#").append(t).append(" ");
            N = Integer.parseInt(br.readLine());
            data = new char[N][N];
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                String a = br.readLine();
                for (int j = 0; j < N; j++) {
                    data[i][j] = a.charAt(j);
                    map[i][j] = 9;
                }
            }
            cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (data[i][j] == '.' && map[i][j] != 0){
                        bfs(i, j);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
