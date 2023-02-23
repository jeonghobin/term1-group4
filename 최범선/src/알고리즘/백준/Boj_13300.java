package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_13300 {
    static int[][] data;
    static int N, cnt;

    public static void recursive(int y){
        if (y == N){
            cnt++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if(!check(i, y)) continue;
            data[i][y] = 1;
            recursive(y + 1);
            data[i][y] = 0;
        }
    }
    public static boolean check(int x, int y){
        if (y == 0) return true;
        for (int i = 0; i < y; i++) {
            if (data[x][i] == 1) return false;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < y; j++) {
                if(data[i][j] == 1 && Math.abs(x-i) == Math.abs(y-j)) return false;
            }
        }
        return true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        data = new int[N][N];
        cnt = 0;

        recursive(0);
        System.out.println(cnt);
    }

}
