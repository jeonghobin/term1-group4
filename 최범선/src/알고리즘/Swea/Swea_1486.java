package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_1486 {
    static int N, K, min;
    static int[] data;

    public static void comb(int idx, int cnt){
//        System.out.println(idx + " " + cnt);

        if (cnt >= K){
            min = Math.min(min, cnt - K);
            return;
        }
        if(idx >= N) return;

        for (int i = idx; i < N; i++) {
            comb(i + 1, cnt + data[i]);
        }

    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(st.nextToken());
        for (int t = 1; t < tc + 1; t++) {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            data = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                data[i] = Integer.parseInt(st.nextToken());
            }
            min = Integer.MAX_VALUE;
            comb(0, 0);
            sb.append(min).append("\n");
        }
        System.out.println(sb);
    }
}
