package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_5215 {

    static int N, total_calroie;
    static diet[] d, s;
    static int max;
    public static class diet{
        int x, y;
        public diet(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void recursive(int cnt, int start) {

        int total = 0;
        int score = 0;
        if (cnt >= N + 1) {
            return;
        }
        for (int i = 0; i < cnt; i++) {
            total += s[i].y;
            score += s[i].x;
        }
        if (total <= total_calroie) {
            if (score > max) {
                max = score;
            }
        }
        for (int i = start; i < N; i++) {
            s[cnt] = new diet(d[i].x, d[i].y);
            recursive(cnt + 1, i + 1);
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int t = 1; t < tc + 1; t++) {
            st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ");
            N = Integer.parseInt(st.nextToken());
            total_calroie = Integer.parseInt(st.nextToken());
            d = new diet[N];
            s = new diet[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine().trim());
                d[i] = new diet(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            max = Integer.MIN_VALUE;
            recursive(0, 0);
            sb.append(max);
            System.out.println(sb);
        }


    }
}