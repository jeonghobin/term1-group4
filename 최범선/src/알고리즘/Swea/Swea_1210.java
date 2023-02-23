package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_1210 {
    static int[][] data;
    static StringBuilder sb;
    static boolean[][] v;
    static int[] d = {-1,1};

    public static void find(int x, int y){
        while (x > 0){
            x--;
            if (x == 0) {
                sb.append(y).append("\n");
                break;
            }
            v[x][y] = true;
            for (int i = 0; i < 2; i++) {
                int t = y + d[i];
                while (t >= 0 && t < 100 && data[x][t] == 1 && !v[x][t]){
                    y = t;
                    v[x][y] = true;
                    t += d[i];
            }
        }
    }
}

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        for (int tc = 1; tc < 11; tc++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            sb.append("#").append(t).append(" ");
            data = new int[100][100];
            v = new boolean[100][100];
            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    data[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < 100; i++) {
                if (data[99][i] == 2){
                    v[99][i] = true;
                    find(99, i);
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
