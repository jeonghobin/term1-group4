package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_23888 {

    public static long gcd(long a, long b){

        if (b == 0) return a;
        return gcd(b, a % b);

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        long x = Math.max(a, d);
        long y = Math.min(a, d);
        long ans = gcd(x,y);

        st = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            long s = Long.parseLong(st.nextToken());
            long e = Long.parseLong(st.nextToken());
            if (c == 1) {
                long sum = ((a + (s-1) * d) + (a + (e-1) * d)) * (e-s+1) / 2;
                sb.append(sum);
            }
            else{
                if (s == e) sb.append(a + (s - 1) * d );
                else{
                    sb.append(ans);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);


    }
}
