package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Swea_1859 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        long tc = Long.parseLong(br.readLine());

        for (int t = 1; t < tc + 1; t++) {
            sb.append("#").append(t).append(" ");

            int K = Integer.parseInt(br.readLine());
            int[] data = new int[K];
            st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < K; i++) {
                data[i] = Integer.parseInt(st.nextToken());
            }
            Stack<Integer> s = new Stack<>();
            s.add(data[K-1]);
            long cnt = 0;
            for (int i = K - 2; i > -1; i--) {
                if (data[i] <= s.peek()) cnt += s.peek() - data[i];
                else {
                    s.pop();
                    s.add(data[i]);
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

}

