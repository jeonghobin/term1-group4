package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1149{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][]data = new int[N + 1][3];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] memo = new int[N + 1][3];
        for (int i = 1; i < N + 1; i++) {
            memo[i][0] = data[i][0] + Math.min(memo[i-1][2], memo[i-1][1]);
            memo[i][1] = data[i][1] + Math.min(memo[i-1][0], memo[i-1][2]);
            memo[i][2] = data[i][2] + Math.min(memo[i-1][0], memo[i-1][1]);
        }

        Arrays.sort(memo[N]);
        System.out.println(memo[N][0]);
    }
}


//public class Boj_1149 {
//    static int N, rsl;
//    static int[][] data;
//
//    public static void dfs(int x, int y, int cnt){
//        if(rsl < cnt) return;
//
//        if (x == N){
//            rsl = Math.min(rsl, cnt);
//            return;
//        }
//
//        for (int i = 0; i < 3; i++) {
//            if (i == y) continue;
//            dfs(x + 1, i, cnt + data[x][i]);
//        }
//
//    }
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(st.nextToken());
//        data = new int[N][3];
//
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < 3; j++) {
//                data[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//        rsl = Integer.MAX_VALUE;
//        for (int i = 0; i < 3; i++) {
//            dfs(1, i, data[0][i]);
//        }
//
//        System.out.println(rsl);
//    }
//}
