package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea_1208 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int t = 1; t < 11; t++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] data = new int[100];
            int idx = 0;
            while (st.hasMoreTokens()) {
                data[idx++] = Integer.parseInt(st.nextToken());
            }
            while (N > 0) {
                Arrays.sort(data);
                int max = data[99];
                int min = data[0];
                if (max == min) return;
                data[99]--;
                data[0]++;
                N--;
            }
            Arrays.sort(data);
            System.out.println("#" + t + " " + (data[99] - data[0]));

        }

    }
}