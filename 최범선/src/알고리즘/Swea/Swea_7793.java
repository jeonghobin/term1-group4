package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea_7793 {
    static int N, M;
    static char[][] c;
    static boolean[][] v;
    static Queue<Pair> q;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static boolean flag;
    static StringBuilder sb;
    public static class Pair{
        int x, y, time;
        public Pair(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    public static void bfs(){

        while (!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            if(c[x][y] == 'S'){
                v[x][y] = true;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(nx >= 0 && nx < N && ny >= 0 && ny < M){
                        if(v[nx][ny]) continue;
                        if (c[nx][ny] == '.') {
                            c[nx][ny] = 'S';
                            q.add(new Pair(nx, ny, p.time + 1));
                        }
                        else if (c[nx][ny] == 'D'){
                            flag = true;
                            sb.append(p.time + 1).append("\n");
                            return;
                        }

                    }
                }
            }else if(c[x][y] == '*'){
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                        if(c[nx][ny] == 'X' || c[nx][ny] == '*' || c[nx][ny] == 'D') continue;
                        c[nx][ny] = '*';
                        q.add(new Pair(nx, ny, p.time + 1));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());
        for (int t = 1; t < tc + 1; t++) {
            sb.append("#").append(t).append(" ");
            flag = false;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            c = new char[N][M];
            v = new boolean[N][M];
            q = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                String a = br.readLine();
                for (int j = 0; j < M; j++) {
                    c[i][j] = a.charAt(j);
                    if(c[i][j] == 'S') q.add(new Pair(i, j, 0));
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(c[i][j] == '*') q.add(new Pair(i, j, 0));
                }
            }
            bfs();
            if(!flag) sb.append("GAME OVER\n");
        }
        System.out.println(sb);
    }
}
