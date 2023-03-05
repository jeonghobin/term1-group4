package 알고리즘.백준;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_17144 {

    static int R, C, T;
    static int x1,y1,x2,y2;
    static int[][] data;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {1,0,-1,0};

    static int[] ddx = {0,1,0,-1};
    static int[] ddy = {1,0,-1,0};
    static Queue<Pair> q = new LinkedList<>();

    static class Pair{
        int x, y, dust;
        public Pair(int x, int y, int dust) {
            this.x = x;
            this.y = y;
            this.dust = dust;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    ", dust=" + dust +
                    '}';
        }
    }

    public static void expand(int time){

        if (time == T) return;

        while (!q.isEmpty()){
            Pair t = q.poll();
            int x = t.x;
            int y = t.y;
            int val = t.dust;
            int cnt = 0;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                if (data[nx][ny] == -1) continue;
                data[nx][ny] += val / 5;
                cnt++;
            }
            data[x][y] -= (val / 5) * cnt;
        }
        clean_up();
        clean_down();
        find();
        expand(time + 1);

    }

    public static void find(){
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(data[i][j] > 0) q.add(new Pair(i, j, data[i][j]));
            }
        }
    }

    public static void clean_up(){

        int idx = 0;
        int nx = x1;
        int ny = y1;
        int start = 0;

        while (true){
            if (nx + dx[idx] < 0 || nx + dx[idx] > x1 || ny + dy[idx] < 0 || ny + dy[idx] >= C){
                idx++;
                idx %= 4;
            }
            nx += dx[idx];
            ny += dy[idx];

            if (nx == x1 && ny == y1) break;
            int temp = data[nx][ny];
            data[nx][ny] = start;
            start = temp;
        }
    }
    public static void clean_down(){

        int idx = 0;
        int nx = x2;
        int ny = y2;
        int start = 0;
        while (true){
            if (nx + ddx[idx] < x2 || nx + ddx[idx] >= R || ny + ddy[idx] < 0 || ny + ddy[idx] >= C){
                idx++;
                idx %= 4;
            }
            nx += ddx[idx];
            ny += ddy[idx];
            if (nx == x2 && ny == y2) break;
            int temp = data[nx][ny];
            data[nx][ny] = start;
            start = temp;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        data = new int[R][C];
        boolean flag = false;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
                if(data[i][j] > 0) q.add(new Pair(i, j, data[i][j]));
                if(data[i][j] == -1 && !flag){
                    flag = true;
                    x1 = i;
                    y1 = j;
                }else if (data[i][j] == -1 && flag){
                    x2 = i;
                    y2 = j;
                }
            }
        }
        expand(0);
        int sum = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (data[i][j] > 0) sum += data[i][j];
            }
        }
        System.out.println(sum);

    }
}
