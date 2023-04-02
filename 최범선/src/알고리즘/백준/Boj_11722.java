package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_11722 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] data = new int[N + 1];
        int[] memo = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N + 1; i++) {
            memo[i] = 1;
            for (int j = 1; j < i; j++) {
                if (data[j] > data[i]) memo[i] = Math.max(memo[i], memo[j] + 1);
            }
        }
        Arrays.sort(memo);
        System.out.println(memo[N]);


    }
}
