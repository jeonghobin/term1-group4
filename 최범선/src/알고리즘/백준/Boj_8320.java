package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_8320 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int data[] = new int[10001];
        data[1] = 1;
        data[2] = 2;

        for (int i = 3; i < N + 1; i++) {
            int cnt = 0;
            for (int j = 1; j < (int)Math.sqrt(i) + 1; j++) {
                if (i % j == 0) cnt ++;
            }
            data[i] = data[i-1] + cnt;
        }
        System.out.println(data[N]);

    }
}
