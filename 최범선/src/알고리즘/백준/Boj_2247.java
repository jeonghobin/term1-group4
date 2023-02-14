package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2247 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long sum = 0;
        for (int i = 2; i < N / 2 + 1; i++) {
            sum += (long) (N / i - 1) * i;
            sum %= 1000000;
        }

        System.out.println(sum);

    }
}
