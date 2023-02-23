package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2630 {

    static int[][] data;
    static int w, b, N;

    public static void divide(int x, int y, int size) {

        int cnt = 0;
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (data[i][j] == 1) cnt++;
            }
        }

        if (cnt == size * size) b++;
        else if (cnt == 0) w++;
        else {
            int r = size / 2;
            divide(x, y, r);
            divide(x, y + r, r);
            divide(x + r, y, r);
            divide(x + r, y + r, r);
        }

    }


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        data = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);

        sb.append(w).append("\n").append(b);
        System.out.println(sb);

    }
}