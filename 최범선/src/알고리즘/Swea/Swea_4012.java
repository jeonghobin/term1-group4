package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_4012 {

    static int[][] data;
    static int N, min, total;
    static int[] index, temp;

    public static void gg(int cnt, int start) {

        if (cnt >= (N+1)/2) {
            boolean[] v = new boolean[N+1];
            for (int i = 0; i < temp.length; i++) {
                v[temp[i]] = true;
            }
            int arr[] = new int[(N+1) / 2];
            int idx = 0;
            for (int i = 1; i < index.length; i++) {
                if (!v[i]) arr[idx++] = i;
            }

            int sum = 0;
            for (int i = 0; i < temp.length; i++) {
                for (int j = i + 1; j < temp.length; j++) {
                    sum += data[temp[i]][temp[j]] + data[temp[j]][temp[i]];
                }
            }
            int r = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    r += data[arr[i]][arr[j]] + data[arr[j]][arr[i]];
                }
            }
            min = Math.min(min, Math.abs(sum - r));
            return;
        }

        for (int i = start; i < index.length; i++) {
            temp[cnt] = index[i];
            gg(cnt + 1, i + 1);

        }

    }



    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int t = 1; t < tc + 1; t++) {
            sb.append("#").append(t).append(" ");
            N = Integer.parseInt(br.readLine());
            min = Integer.MAX_VALUE;

            data = new int[N+1][N+1];

            index = new int[N+1];

            temp = new int[(N+1) / 2];

            int total = 0;
            for (int i = 1; i < N + 1; i++) {
                index[i] = i;
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j < N + 1; j++) {
                    data[i][j] = Integer.parseInt(st.nextToken());
                    total += data[i][j];
                }
            }
            gg(0, 1);

            sb.append(min).append("\n");
        }
        System.out.println(sb);

    }

}
