package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea_3307 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int t = 1; t < tc + 1; t++) {
            sb.append("#").append(t).append(" ");
            int N = Integer.parseInt(br.readLine());
            long[] data = new long[N];
            int[] d = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                data[i] = Long.parseLong(st.nextToken());
            }

            for (int i = 0; i < N; i++) {
                d[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (data[j] < data[i]) d[i] = Math.max(d[i], d[j] + 1);
                }
            }
//            System.out.println(Arrays.toString(d));
            Arrays.sort(d);
            sb.append(d[N-1]).append("\n");
        }
        System.out.println(sb);
    }
}
