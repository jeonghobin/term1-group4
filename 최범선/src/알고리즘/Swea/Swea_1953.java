package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea_1953 {
    static int R, C, a, b, L, cnt;
    static int[][] data;
    static boolean[][] v;
    public static class Pair{
        int x, y, time;
        public Pair(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void bfs(){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(a,b,1));
        v[a][b] = true;
        while (!q.isEmpty()){
            Pair t = q.poll();
            int x = t.x;
            int y = t.y;
            if(t.time > L) return;
            cnt++;
            if(data[x][y] == 1){
                if(up(x, y)) {
                    v[x-1][y] = true;
                    q.add(new Pair(x-1, y, t.time + 1));
                }
                if(right(x, y)) {
                    v[x][y + 1] = true;
                    q.add(new Pair(x, y+1, t.time + 1));
                }
                if(down(x, y)) {
                    v[x+1][y] = true;
                    q.add(new Pair(x+1, y, t.time + 1));
                }
                if(left(x, y)){
                    v[x][y-1] = true;
                    q.add(new Pair(x, y-1, t.time + 1));
                }
            }else if(data[x][y] == 3){
                if(left(x, y)) {
                    v[x][y-1] = true;
                    q.add(new Pair(x, y-1, t.time + 1));
                }
                if(right(x, y)) {
                    v[x][y + 1] = true;
                    q.add(new Pair(x, y+1, t.time + 1));
                }
            }else if(data[x][y] == 2){
                if(up(x, y)) {
                    v[x-1][y] = true;
                    q.add(new Pair(x-1, y, t.time + 1));
                }
                if(down(x, y)){
                    v[x+1][y] = true;
                    q.add(new Pair(x+1, y, t.time + 1));
                }
            }else if(data[x][y] == 4){
                if(up(x, y)){
                    v[x-1][y] = true;
                    q.add(new Pair(x-1, y, t.time + 1));
                }
                if(right(x, y)){
                    v[x][y+1] = true;
                    q.add(new Pair(x, y+1, t.time + 1));
                }
            }else if(data[x][y] == 5){
                if(down(x, y)) {
                    v[x+1][y] = true;
                    q.add(new Pair(x+1, y, t.time + 1));
                }
                if(right(x, y)) {
                    v[x][y+1] = true;
                    q.add(new Pair(x, y+1, t.time + 1));
                }
            }else if(data[x][y] == 6){
                if(left(x, y)){
                    v[x][y-1] = true;
                    q.add(new Pair(x, y-1, t.time + 1));
                }
                if(down(x, y)) {
                    v[x+1][y] = true;
                    q.add(new Pair(x+1, y, t.time + 1));
                }
            }else if(data[x][y] == 7){
                if(left(x, y)) {
                    v[x][y-1] = true;
                    q.add(new Pair(x, y-1, t.time + 1));
                }
                if(up(x, y)) {
                    v[x-1][y] = true;
                    q.add(new Pair(x-1, y, t.time + 1));
                }
            }

        }
    }
    public static boolean check(int x, int y){
        return x >= 0 && x < R && y >= 0 && y < C && !v[x][y];
    }
    public static boolean up(int x, int y){
        if(!check(x-1, y)) return false;
        return data[x - 1][y] == 1 || data[x - 1][y] == 2 || data[x - 1][y] == 5 || data[x - 1][y] == 6;
    }
    public static boolean down(int x, int y){
        if(!check(x+1, y)) return false;
        return data[x + 1][y] == 1 || data[x + 1][y] == 2 || data[x + 1][y] == 4 || data[x + 1][y] == 7;
    }

    public static boolean right(int x, int y){
        if(!check(x, y + 1)) return false;
        return data[x][y + 1] == 1 || data[x][y + 1] == 3 || data[x][y + 1] == 6 || data[x][y + 1] == 7;
    }

    public static boolean left(int x, int y){
        if(!check(x, y - 1)) return false;
        return data[x][y - 1] == 1 || data[x][y - 1] == 3 || data[x][y - 1] == 4 || data[x][y - 1] == 5;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());
        for (int t = 1; t < tc + 1; t++) {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            data = new int[R][C];
            v = new boolean[R][C];
            cnt = 0;

            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < C; j++) {
                    data[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            bfs();
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
