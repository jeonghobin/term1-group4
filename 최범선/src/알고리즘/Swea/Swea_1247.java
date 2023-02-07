package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_1247 {

    static Point[] c, s;
    static Point start, end;
    static int max, N;
    static boolean[] v;

    public static class Point{
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void recursive(int cnt){
        if (cnt == N){
            int x = start.x, y = start.y, total = 0;
            for (int i = 0; i < N; i++) {
                total += Math.abs(x - s[i].x) + Math.abs(y - s[i].y);
                x = s[i].x;
                y = s[i].y;
            }
            total += Math.abs(x - end.x) + Math.abs(y - end.y);
            max = Math.min(max, total);
            return;
        }
        for (int i = 0; i < N; i++) {
            if(v[i]) continue;
            v[i] = true;
            s[cnt] = c[i];
            recursive(cnt + 1);
            v[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t < tc + 1; t++) {

            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ");
            start = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            end = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));

            c = new Point[N];
            s = new Point[N];
            v = new boolean[N];

            for (int i = 0; i < N; i++) {
                c[i] = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            }
            max = Integer.MAX_VALUE;

            recursive(0);
            sb.append(max);

            System.out.println(sb);
        }
    }
}
