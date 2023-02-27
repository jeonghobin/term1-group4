package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_3289 {
    static int[] data;

    public static int find(int idx){
        if (data[idx] == idx) return idx;
        return data[idx] = find(data[idx]);
    }

    public static void union(int x, int y){
        int a = Math.min(x, y);
        int b = Math.max(x, y);

        int fa = find(a);
        int fb = find(b);

        if(fa != fb) data[fb] = fa;

    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(st.nextToken());

        for (int t = 1; t < tc + 1; t++) {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            data = new int[N + 1];
            for (int i = 1; i < N + 1; i++) {
                data[i] = i;
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int d = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(d == 1){
                    if(find(a) == find(b))sb.append(1);
                    else sb.append(0);
                }else union(a , b);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

