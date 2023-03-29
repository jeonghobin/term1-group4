package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_9095 {

    static int K, cnt;

    static void recursive(int sum){

        if (sum > K) return;
        if(sum == K){
            cnt++;
            return;
        }
        for (int i = 1; i <= 3; i++) {
            recursive(sum + i);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            K = Integer.parseInt(br.readLine());
            cnt = 0;
            recursive(0);
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
