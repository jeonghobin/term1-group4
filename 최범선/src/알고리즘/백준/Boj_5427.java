package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_5427 {

    static int N, R, C, rsl;
    static int[][] data;
    static Queue<Pair> q;
    static boolean[][]  v;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static class Pair{
        int x, y, time;
        public Pair(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    public static void bfs(){

        while (!q.isEmpty()){
            Pair t = q.poll();
            int x = t.x;
            int y = t.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx > R + 1 || ny < 0 || ny > C + 1) continue;
                if (data[x][y] == 1){
                    if (nx < 1 || nx > R || ny < 1 || ny > C){
                        rsl = t.time + 1;
                        return;
                    }
                    if (v[nx][ny]) continue;
                    if (data[nx][ny] == -1){
                        data[nx][ny] = 1;
                        v[nx][ny] = true;
                        q.add(new Pair(nx, ny, t.time+1));
                    }
                }else if (data[x][y] == 2 && (data[nx][ny] == 1 || data[nx][ny] == -1)){
                    data[nx][ny] = 2;
                    q.add(new Pair(nx, ny, t.time + 1));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());

            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());

            data = new int[R + 2][C + 2];
            v = new boolean[R+2][C+2];
            q = new LinkedList<>();
            for (int i = 1; i < R + 1; i++) {
                String a = br.readLine();
                for (int j = 1; j < C + 1; j++) {
                    char temp = a.charAt(j - 1);
                    if (temp == '.') data[i][j] = -1;
                    else if(temp == '@') {
                        data[i][j] = 1;
                        v[i][j] = true;
                        q.add(new Pair(i, j,0));
                    }else if(temp == '*') data[i][j] = 2;
                }
            }

            for (int i = 1; i < R + 1; i++) {
                for (int j = 1; j < C + 1; j++) {
                    if (data[i][j] == 2) q.add(new Pair(i, j,0));
                }
            }
            rsl = -1;
            bfs();
            sb.append(rsl == -1 ? "IMPOSSIBLE" : rsl).append("\n");
        }
        System.out.println(sb);
    }
}
