package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_17406 {
    static int R, C, K, min;
    static int[][] data, map;
    static Pair[] p;
    static int[] dx = {1, 0, -1, 0}, sel;
    static boolean[] v;
    static int[] dy = {0, 1, 0, -1};
    static class Pair{
        int r, c, s;
        public Pair(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }
    public static void rotate(int a, int b, int d){
        int x = a - d;
        int y = b - d;
        for (int i = 0; i < d; i++) {
            int nx = x + i;
            int ny = y + i;
            int start = map[nx][ny];
            int idx = 0;
            while (true){
                if(!(nx + dx[idx] >= (a-d+i) && nx + dx[idx] <= (a+d-i) && ny + dy[idx] >= (b-d+i) && ny + dy[idx] <= (b+d-i))){
                    idx++;
                    idx %= 4;
                }
                if(nx + dx[idx] == a-d+i && ny + dy[idx] == b-d+i) {
                    map[nx][ny] = start;
                    break;
                }
                map[nx][ny] = map[nx + dx[idx]][ny + dy[idx]];
                nx += dx[idx];
                ny += dy[idx];
            }
        }
    }
    public static void select(int idx){

        if (idx >= K){
            for (int i = 0; i < K; i++) {
                rotate(p[sel[i]].r, p[sel[i]].c, p[sel[i]].s);
            }

            for (int i = 1; i < R + 1; i++) {
                int sum = 0;
                for (int j = 1; j < C + 1; j++) sum += map[i][j];
                min = Math.min(min, sum);
            }
            for (int i = 0; i < R + 1; i++) map[i] = Arrays.copyOf(data[i], C + 1);
            return;
        }

        for (int i = 0; i < K; i++) {
            if(v[i]) continue;
            v[i] = true;
            sel[idx] = i;
            select(idx + 1);
            v[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        data = new int[R + 1][C + 1];
        map = new int[R + 1][C + 1];

        for (int i = 1; i < R + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < C + 1; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
            map[i] = Arrays.copyOf(data[i], C + 1);
        }
        p = new Pair[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            p[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        sel = new int[K];
        v = new boolean[K];
        min = Integer.MAX_VALUE;
        select(0);
        System.out.println(min);
    }
}


