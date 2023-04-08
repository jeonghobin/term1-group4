package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_16918 {
    static int R, C, K;
    static char[][] data;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    static Queue<Pair> q;

    static class Pair{
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void check(){
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(data[i][j] == 'O') q.add(new Pair(i, j));
            }
        }
    }
    static void draw(){
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(data[i][j] == 'O') continue;
                data[i][j] = 'O';
            }
        }
    }
    static void bomb(){

        boolean[][] v = new boolean[R][C];
        while (!q.isEmpty()){
            Pair t = q.poll();
            int x = t.x;
            int y = t.y;
            data[x][y] = '.';
            v[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= R || ny < 0 || ny >= C || v[nx][ny]) continue;
                v[nx][ny] = true;
                data[nx][ny] = '.';
            }

        }

    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        data = new char[R][C];
        q = new LinkedList<>();


        for (int i = 0; i < R; i++) {
            String a = br.readLine();
            for (int j = 0; j < C; j++) {
                data[i][j] = a.charAt(j);

            }
        }
        int t = K % 4;
        while (true){
            if (K == 1) {
                print();
                break;
            }
            check();
            draw();
            if (t % 2 == 0){
                print();
                break;
            }
            bomb();
            if (t == 3){
                print();
                break;
            }
            check();
            draw();
            bomb();
            print();
            break;
        }
    }

    static void print(){
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(data[i][j]);
            }
            System.out.println();
        }
    }

}
