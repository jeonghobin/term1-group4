package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2961 {

    static pair p[];
    static int N, min;
    static boolean v[];

    public static class pair{
        int x,y;

        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void recursive(int idx, int s, int b) {
        if (idx >= N) {
            if(s != 1 && b != 0)min = Math.min(min, Math.abs(s-b));
            return;
        }
        v[idx] = true;

        recursive(idx + 1, s * p[idx].x, b + p[idx].y);
        v[idx] = false;
        recursive(idx + 1, s, b);
    }


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        p = new pair[N];
        v = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            p[i] = new pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        min = Integer.MAX_VALUE;

        recursive(0, 1, 0);
        sb.append(min);
        System.out.println(min);



    }
}

