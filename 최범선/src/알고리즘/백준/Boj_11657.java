package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_11657 {

    static class Pair{
        int start, end, cost;
        public Pair(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] d = new long[N];
        Arrays.fill(d, Integer.MAX_VALUE);
        Pair[] p = new Pair[M];

        int s,e,c;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            p[i] = new Pair(s-1,e-1,c);
        }
        boolean flag = true;
        d[0] = 0;
        for (int i = 0; i < N; i++) {
            for (Pair pair : p) {
                int start = pair.start;
                int end = pair.end;
                int cost = pair.cost;

                if (d[start] == Integer.MAX_VALUE) continue;

                if (d[end] > d[start] + cost){
                    d[end] = d[start] + cost;
                    if (i == N - 1) flag = false;
                }
            }
        }
        System.out.println(Arrays.toString(d));

        if (!flag) System.out.println(-1);
        else{
            for (int i = 1; i < N; i++) {
                if (d[i] == Integer.MAX_VALUE) sb.append(-1).append("\n");
                else sb.append(d[i]).append("\n");
            }
        }
        System.out.println(sb);

    }
}
