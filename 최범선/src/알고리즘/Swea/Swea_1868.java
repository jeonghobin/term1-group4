package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
public class Swea_1868 {
    static int N;
    static char[][] c;
    static int[][] map;
    static int[] dx = {0,1,0,-1,1,1,-1,-1};
    static int[] dy = {1,0,-1,0,1,-1,-1,1};
    public static class Pair{
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int check(int x, int y){
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if(c[nx][ny] == '*') cnt++;
            }
        }
        return cnt;
    }
    public static void bfs(int a, int b){
        map[a][b] = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(a, b));

        while (!q.isEmpty()){
            Pair t = q.poll();
            int x = t.x;
            int y = t.y;
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N){
                    if(map[nx][ny] != 0 && c[nx][ny] == '.'){
                        if (check(nx, ny) == 0) q.add(new Pair(nx, ny));
                        map[nx][ny] = 0;
                    }
                }
            }
        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t < tc + 1; t++) {
            sb.append("#").append(t).append(" ");
            N = Integer.parseInt(br.readLine());
            c = new char[N][N];
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                String a = br.readLine();
                for (int j = 0; j < N; j++) {
                    c[i][j] = a.charAt(j);
                    map[i][j] = -1;
                }
            }
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(c[i][j] == '.' && check(i,j) == 0 && map[i][j] != 0){
                        bfs(i, j);
                        cnt++;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j] != 0 && c[i][j] == '.') cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}