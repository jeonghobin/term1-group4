package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_14502 {
    static int R, C, rsl;
    static int[][] data, temp;
    static Queue<Pair> q;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    static class Pair{
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

    static void recursive(int cnt){
        if (cnt == 3){
            bfs();
            return;
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (data[i][j] == 0){
                    data[i][j] = 1;
                    recursive(cnt + 1);
                    data[i][j] = 0;
                }
            }
        }
    }
    static void bfs(){
        boolean[][] v = new boolean[R][C];
        Queue<Pair> q = new LinkedList<>();
        temp = new int[R][C];
        for (int i = 0; i < R; i++) {
            temp[i] = Arrays.copyOf(data[i], C);
            for (int j = 0; j < C; j++) {
                if (temp[i][j] == 2) {
                    v[i][j] = true;
                    q.add(new Pair(i, j));
                }
            }
        }
        while (!q.isEmpty()){
            Pair t = q.poll();
            int x = t.x;
            int y = t.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C || v[nx][ny]) continue;
                if (temp[nx][ny] != 0) continue;
                v[nx][ny] = true;
                temp[nx][ny] = 2;
                q.add(new Pair(nx, ny));
            }
        }
//        print();
        rsl = Math.max(rsl, count());
    }
    static int count(){
        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (temp[i][j] == 0) sum++;
            }
        }
        return sum;
    }
    static void print(){
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        data = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        rsl = -1;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
//                System.out.println(i + " " + j);
                if (data[i][j] == 0){
                    data[i][j] = 1;
                    recursive(1);
                    data[i][j] = 0;
                }
            }
        }
        System.out.println(rsl);
    }
}
