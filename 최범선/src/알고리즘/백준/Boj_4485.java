package 알고리즘.백준;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_4485 {
    static int N;
    static int[][] data, d;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    static class Pair{
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static void bfs(){

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        d[0][0] = data[0][0];

        while (!q.isEmpty()){
            Pair t = q.poll();
            int x = t.x;
            int y = t.y;


            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(d[nx][ny] > d[x][y] + data[nx][ny]){
                    d[nx][ny] = d[x][y] + data[nx][ny];
                    q.add(new Pair(nx ,ny));
                }
            }

        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int idx = 1;
        while (true){
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            sb.append("Problem ").append(idx++).append(": ");
            data = new int[N][N];
            d = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                Arrays.fill(d[i], Integer.MAX_VALUE);
                for (int j = 0; j < N; j++) {
                    data[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            bfs();
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < N; j++) {
//                    System.out.print(d[i][j] + " ");
//                }
//                System.out.println();
//            }
            sb.append(d[N-1][N-1]).append("\n");
        }

        System.out.println(sb);
    }
}
