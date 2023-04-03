package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_17069 {
    static int N;
    static long cnt;
    static int[][] data;
    static long[][][] d;
    static int[] dx = {0,1,1}, cx = {-1, 0};
    static int[] dy = {1,1,0}, cy = {0, -1};

    public static long dfs(int x, int y, int flag){
//        System.out.println(x + " " + y);
        if(x == N - 1 && y == N - 1) {
            return 1;
        }
        if(d[x][y][flag] != -1) return d[x][y][flag];
        d[x][y][flag] = 0;
        for (int i = 0; i < 3; i++) {
            if(flag == 0 && i == 2) continue;
            if(flag == 2 && i == 0) continue;
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= N || ny < 0 || ny >= N || data[nx][ny] == 1) continue;
            if(i==1)if(!check(nx,ny)) continue;

            d[x][y][flag] += dfs(nx, ny, i);
        }
        return d[x][y][flag];
    }

    public static boolean check(int x, int y){

        for (int i = 0; i < 2; i++) {
            int nx = x + cx[i];
            int ny = y + cy[i];
            if(data[nx][ny] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        data = new int[N][N];
        d = new long[N][N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
                for (int k = 0; k < 3; k++) {
                     d[i][j][k] = -1;
                }
            }
        }

        System.out.println(dfs(0, 1, 0));
//        print();


    }

    public static void print(){
        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(d[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
