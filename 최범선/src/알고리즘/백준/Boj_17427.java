package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_17427 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        long[] data = new long[N+1];
        data[1] = 1;
        for (int i = 2; i < N + 1; i++) {
            data[i] += 1;
            for (int j = i; j < data.length; j += i) {
                data[j] += i;
            }
            data[i] = data[i] + data[i-1];
        }
        sb.append(data[N]);
        System.out.println(sb);

    }
}