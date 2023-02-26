package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea_5644 {
    static int M, K, sum;
    static int[] A, B;
    static Pair[] p;
    static boolean[][] v;
    static int[] dx = {0,-1,0,1,0};
    static int[] dy = {0,0,1,0,-1};
    public static class Pair implements Comparable<Pair>{
        int y, x, c, p;
        public Pair(int y, int x, int c, int p) {
            this.y = y;
            this.x = x;
            this.c = c;
            this.p = p;
        }
        @Override
        public int compareTo(Pair o) {
            return o.p - this.p;
        }
    }
    public static void dfs(int x, int y, int xx, int yy, int idx){

        if (idx > M) return;
        int cnt = 0;
        boolean a = false, b = false;
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < K; i++) {
            if((Math.abs(x - p[i].x) + Math.abs(y - p[i].y) <= p[i].c) || (Math.abs(xx - p[i].x) + Math.abs(yy - p[i].y) <= p[i].c)){
                if(Math.abs(x - p[i].x) + Math.abs(y - p[i].y) <= p[i].c && !a){
                    a = true;
                    sum1 += p[i].p;
                }else if(Math.abs(xx - p[i].x) + Math.abs(yy - p[i].y) <= p[i].c && !b){
                    b = true;
                    sum1 += p[i].p;
                }
                if(a&&b) break;
            }
        }
        a = false;
        b = false;
        for (int i = 0; i < K; i++) {
            if((Math.abs(x - p[i].x) + Math.abs(y - p[i].y) <= p[i].c) || (Math.abs(xx - p[i].x) + Math.abs(yy - p[i].y) <= p[i].c)){
                if(Math.abs(xx - p[i].x) + Math.abs(yy - p[i].y) <= p[i].c && !b){
                    b = true;
                    sum2 += p[i].p;
                }else if(Math.abs(x - p[i].x) + Math.abs(y - p[i].y) <= p[i].c && !a){
                    a = true;
                    sum2 += p[i].p;
                }
                if(a&&b) break;
            }
        }
        sum += Math.max(sum1, sum2);
//        System.out.println(idx + " : " + x + " " + y + " " + xx + " " + yy + " " + sum );
        dfs(x + dx[A[idx]], y + dy[A[idx]], xx + dx[B[idx]], yy + dy[B[idx]], idx + 1);
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());
        for (int t = 1; t < tc + 1; t++) {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            A = new int[M + 1];
            B = new int[M + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }
            p = new Pair[K];
            v = new boolean[K][M + 1];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                p[i] = new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            }
            sum = 0;
            Arrays.sort(p);
            dfs(1, 1, 10, 10, 0);
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
