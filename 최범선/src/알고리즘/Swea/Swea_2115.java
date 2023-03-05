package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea_2115 {
    static int N , M, C, max;
    static int[][] data, honey;
    static boolean[] v;
    public static void find(int cnt, int x, int y, int[] sel){

        if(cnt >= M){
            int sum = 0, temp = 0;
            for (int s : sel) {
                if (!(C >= sum + s)) continue;
                sum += s;
                temp += Math.pow(s, 2);
            }
            max = Math.max(max, temp);
            return;
        }
        for (int i = y; i < y + M; i++) {
            if(v[i]) continue;
            sel[cnt] = data[x][i];
            v[i] = true;
            find(cnt + 1, x, y, sel);
            v[i] = false;
        }
    }
    public static boolean check(int l , int j){
        for (int i = l; i < l + M; i++) {
            if(i >= j && i <= j + M - 1) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int t = 1; t < tc + 1; t++) {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            data = new int[N][N];

            honey = new int[N][N - M + 1];


            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    data[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N - M  + 1; j++) {
                    max = -1;
                    v = new boolean[N];
                    find(0, i, j, new int[M]);
                    honey[i][j] = max;
                    Arrays.fill(v, false);
                }
            }
            int max = -1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N - M + 1; j++) {
                    for (int k = 0; k < N; k++) {
                        for (int l = 0; l < N - M + 1; l++) {
                            if (i == k) if (!check(l, j)) continue;
                            max = Math.max(max ,honey[i][j] + honey[k][l]);
                        }
                    }
                }
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}
