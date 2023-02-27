package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Swea_7465 {
    static int[] data;

    public static void union(int x, int y){
        int a = Math.min(x, y);
        int b = Math.max(x, y);

        int fa = find(a);
        int fb = find(b);

        data[fb] = fa;
    }
    public static int find(int idx){
        if(data[idx] == idx) return idx;
        return data[idx] = find(data[idx]);
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
            for (int i = 1; i < N + 1; i++) data[i] = i;

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }
            HashSet<Integer> h = new HashSet<>();
            for (int i = 1; i < N + 1; i++) h.add(find(i));
            sb.append(h.size()).append("\n");
        }
        System.out.println(sb);
    }
}
