package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_2748 {
    static long[] memo;
    static int cnt;

    static long recursive(int idx){
        cnt++;
        if (memo[idx] > 0) return memo[idx];
        if(idx == 0) return memo[idx];
        if(idx <= 2) return 1;

        return memo[idx] = recursive(idx-1) + recursive(idx-2);

    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        memo = new long[n + 1];
//        memo[1] = 1;
//        memo[2] = 1;
        cnt = 0;
        System.out.println(recursive(n));
//        System.out.println(Arrays.toString(memo));
//        System.out.println(cnt);

    }
}
