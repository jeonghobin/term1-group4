package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_16637 {
    static int N, max;
    static String a;

    public static void recursive(int idx, int sum, int d){
        if (idx >= N){
            max = Math.max(max, sum);
            return;
        }
        for (int i = idx; i < N; i++) {
            if (a.charAt(i) == '+' || a.charAt(i) == '-' || a.charAt(i) == '*'){
                if (a.charAt(i) == '+'){
                    d = 1;
                    continue;
                }else if (a.charAt(i) == '-'){
                    d = 2;
                    continue;
                }
                else if (a.charAt(i) == '*'){
                    d = 3;
                    continue;
                }
            }
            if (i + 2 < N){
                int t1 = a.charAt(i) - '0';
                int t2 = a.charAt(i + 2) - '0';

                if (a.charAt(i + 1) == '+') {
                    if (d == 1) recursive(i + 3, sum + (t1 + t2), d);
                    else if (d == 2) recursive(i + 3, sum - (t1 + t2), d);
                    else if (d == 3) recursive(i + 3, sum * (t1 + t2), d);
                }else if (a.charAt(i + 1) == '-') {
                    if (d == 1) recursive(i + 3, sum + (t1 - t2), d);
                    else if (d == 2) recursive(i + 3, sum - (t1 - t2), d);
                    else if (d == 3) recursive(i + 3, sum * (t1 - t2), d);
                }else if (a.charAt(i + 1) == '*') {
                    if (d == 1) recursive(i + 3, sum + (t1 * t2), d);
                    else if (d == 2) recursive(i + 3, sum - (t1 * t2), d);
                    else if (d == 3) recursive(i + 3, sum * (t1 * t2), d);
                }
            }
            if (d == 1) sum += a.charAt(i) - '0';
            else if (d == 2) sum -= a.charAt(i) - '0';
            else if (d == 3) sum *= a.charAt(i) - '0';
        }

        max = Math.max(max, sum);

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        a = br.readLine();

        max = Integer.MIN_VALUE;
        recursive(0, 0, 1);

        System.out.println(max);

    }
}
