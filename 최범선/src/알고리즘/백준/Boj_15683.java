package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_15683 {
    static int N, M, min;
    static ArrayList<Pair> d;
    static int[][] data;

    public static class Pair{
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void left(int x, int y, int k){
        for (int i = y - 1; i > - 1 ; i--) {
            if(data[x][i] == 6) break;
            if(data[x][i] == 0) data[x][i] = k;
        }
    }
    public static void r_left(int x, int y, int k){
        for (int i = y - 1; i > - 1 ; i--) {
            if(data[x][i] == 6) break;
            if(data[x][i] == k) data[x][i] = 0;
        }
    }
    public static void right(int x, int y, int k){
        for (int i = y + 1; i < M ; i++) {
            if(data[x][i] == 6) break;
            if(data[x][i] == 0) data[x][i] = k;
        }
    }
    public static void r_right(int x, int y, int k){
        for (int i = y + 1; i < M ; i++) {
            if(data[x][i] == 6) break;
            if(data[x][i] == k) data[x][i] = 0;
        }
    }
    public static void up(int x, int y, int k) {
        for (int i = x - 1; i > -1; i--) {
            if (data[i][y] == 6) break;
            if (data[i][y] == 0) data[i][y] = k;
        }
    }
    public static void r_up(int x, int y, int k) {
        for (int i = x - 1; i > -1; i--) {
            if (data[i][y] == 6) break;
            if (data[i][y] == k) data[i][y] = 0;
        }
    }
    public static void down(int x, int y, int k) {
        for (int i = x + 1; i < N; i++) {
            if (data[i][y] == 6) break;
            if (data[i][y] == 0) data[i][y] = k;
        }
    }
    public static void r_down(int x, int y, int k) {
        for (int i = x + 1; i < N; i++) {
            if (data[i][y] == 6) break;
            if (data[i][y] == k) data[i][y] = 0;
        }
    }

    public static int check(){
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(data[i][j] != 0) continue;
                cnt++;
            }
        }
        return cnt;
    }

    public static void c(int cnt){

        if (cnt >= d.size()){
            min = Math.min(min, check());
            return;
        }

        Pair p = d.get(cnt);
        int x = p.x;
        int y = p.y;
        int t = data[x][y];

        if (t==1){
            left(x, y, cnt + 7);
            c(cnt + 1);
            r_left(x, y, cnt + 7);
            right(x, y, cnt + 7);
            c(cnt + 1);
            r_right(x, y, cnt + 7);
            up(x, y, cnt + 7);
            c(cnt + 1);
            r_up(x, y, cnt + 7);
            down(x, y, cnt + 7);
            c(cnt + 1);
            r_down(x, y, cnt + 7);
        }else if(t==2){
            left(x, y, cnt + 7);
            right(x, y, cnt + 7);
            c(cnt + 1);
            r_left(x, y, cnt + 7);
            r_right(x, y, cnt + 7);
            up(x, y, cnt + 7);
            down(x, y, cnt + 7);
            c(cnt + 1);
            r_up(x, y, cnt + 7);
            r_down(x, y, cnt + 7);
        }else if(t==3){
            up(x, y, cnt + 7);
            right(x, y, cnt + 7);
            c(cnt + 1);
            r_up(x, y, cnt + 7);
            down(x, y, cnt + 7);
            c(cnt + 1);
            r_right(x, y, cnt + 7);
            left(x, y, cnt + 7);
            c(cnt + 1);
            r_down(x, y, cnt + 7);
            up(x, y, cnt + 7);
            c(cnt + 1);
            r_left(x, y, cnt + 7);
            r_up(x, y, cnt + 7);
        }else if(t==4){
            up(x, y, cnt + 7);
            right(x, y, cnt + 7);
            down(x, y, cnt + 7);
            c(cnt + 1);
            r_up(x, y, cnt + 7);
            left(x, y, cnt + 7);
            c(cnt + 1);
            r_right(x, y, cnt + 7);
            up(x, y, cnt + 7);
            c(cnt + 1);
            r_down(x, y, cnt + 7);
            right(x, y, cnt + 7);
            c(cnt + 1);
            r_left(x, y, cnt + 7);
            r_up(x, y, cnt + 7);
            r_right(x, y, cnt + 7);
        }else if(t==5){
            up(x, y, cnt + 7);
            right(x, y, cnt + 7);
            down(x, y, cnt + 7);
            left(x, y, cnt + 7);
            c(cnt + 1);
            r_up(x, y, cnt + 7);
            r_right(x, y, cnt + 7);
            r_down(x, y, cnt + 7);
            r_left(x, y, cnt + 7);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        d = new ArrayList<>();

        data = new int[N][M];
        min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
                if (data[i][j] > 0 && data[i][j] < 6) d.add(new Pair(i, j));
            }
        }

        c(0);
        System.out.println(min);

    }
}

