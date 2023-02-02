package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_6730 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        for (int i = 1; i < tc + 1; i++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] data = new int[N];
            for (int j = 0; j < N; j++) {
                data[j] = Integer.parseInt(st.nextToken());
            }
            int up = 0, down = 0;

            for (int j = 0; j < N - 1; j++) {
                if (data[j] < data[j+1]) {
                    up = Math.max(up, data[j+1] - data[j]);
                }else if(data[j] > data[j+1]) {
                    down = Math.max(down, data[j] - data[j+1]);
                }
            }
            System.out.println("#" + i + " " + up + " " + down);
        }

    }
}