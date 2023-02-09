package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_7964 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t < tc + 1; t++) {
            st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ");
            int N = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int cnt = 0, count = 0;
            for (int i = 0; i < N; i++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 1){
                    cnt = 0;
                    continue;
                }
                cnt++;
                if (cnt >= dis){
                    count++;
                    cnt = 0;
                }
            }
            sb.append(count);
            System.out.println(sb);
        }
    }
}
