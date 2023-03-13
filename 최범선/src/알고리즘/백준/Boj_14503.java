package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_14503 {
    static int[][] data;
    static int x, y, d, N, M, cnt;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] v;

    static class Pair{
        int x, y, d;
        public Pair(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    public static void gg(){

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y, d));
        data[x][y] = -1;
        while (!q.isEmpty()){

            Pair t = q.poll();
            int x = t.x;
            int y = t.y;
            int d = t.d;
//            System.out.println(x + " " + y);
            if(data[x][y] == -1 && !v[x][y]) {
                v[x][y] = true;
                cnt++;
            }
            if(!check(x, y)){
                int nx = x + dx[(d+2) % 4];
                int ny = y + dy[(d+2) % 4];

                if (dddd(nx, ny) && data[nx][ny] != 1){
                    if(data[nx][ny] == 0) data[nx][ny] = -1;
                    q.add(new Pair(nx, ny, d));
                }
            }else{
                if (d == 0) d = 4;
                d--;
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (dddd(nx, ny) && data[nx][ny] == 0){
                    data[nx][ny] = -1;
                    q.add(new Pair(nx, ny, d));
                }else{
                    q.add(new Pair(x, y, d));
                }
            }

        }
    }


    public static boolean dddd(int x, int y){return !(x < 0 || x >= N || y < 0 || y >= M);}

    public static boolean check(int x, int y){
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (!dddd(nx, ny)) continue;
            if (data[nx][ny] == 0) return true;
        }
        return false;
    }

    // 4방에 갈 수 있는곳이 있으면 true

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        data = new int[N][M];
        v = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        cnt = 0;
        gg();

        System.out.println(cnt);


    }
}
