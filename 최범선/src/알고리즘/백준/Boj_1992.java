package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1992 {

    static int N;
    static int[][] data;
    static StringBuilder sb;

    public static void divide(int x, int y, int size) {

        int cnt = 0;
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (data[i][j] == 1) cnt++;
            }
        }

        if(cnt == size * size) sb.append(1);
        else if(cnt == 0) sb.append(0);
        else {
            int r = size/2;
            sb.append("(");
            divide(x, y, r);
            divide(x, y + r, r);
            divide(x + r, y, r);
            divide(x + r, y + r, r);
            sb.append(")");
        }

    }

    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        data = new int[N][N];

        for (int i = 0; i < N; i++) {
            String a = br.readLine();
            for (int j = 0; j < N; j++) {
                data[i][j] = a.charAt(j) - '0';
            }
        }

        divide(0, 0, N);

        System.out.println(sb);

    }
}