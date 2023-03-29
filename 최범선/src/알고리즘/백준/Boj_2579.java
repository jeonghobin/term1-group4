package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_2579 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] memo = new int[10001];
        int[] data = new int[10001];

        for (int i = 1; i < N + 1; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }
        memo[1] = data[1];
        memo[2] = data[1] + data[2];
        for (int i = 3; i < N + 1; i++) {
            memo[i] = memo[i-2] + data[i];
            memo[i] = Math.max(memo[i], memo[i-3] + data[i] + data[i-1]);

        }
//        System.out.println(Arrays.toString(memo)) ;
        System.out.println(memo[N]);
    }

}
