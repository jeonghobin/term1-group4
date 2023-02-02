package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_6958 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t < tc + 1; t++) {
            st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            sb.append("#").append(t).append(" ");
            int per = 1, pro = -1;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int cnt = 0;
                for (int j = 0; j < M; j++) {
                    int temp = Integer.parseInt(st.nextToken());
                    if (temp == 1) cnt++;
                }
                if (pro < cnt) {
                    pro = cnt;
                    per = 1;
                } else if (pro == cnt) {
                    per++;
                }
            }
            sb.append(per).append(" ").append(pro);
            System.out.println(sb);
        }


    }
}