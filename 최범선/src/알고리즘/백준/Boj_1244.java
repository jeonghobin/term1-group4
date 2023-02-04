package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj_1244 {

    static int[] data;
    static int N;

    public static void change(int k, int v) {
        int cnt = 0;
        if (k == 1) {
            for (int i = v; i < N + 1; i += v) {
                data[i]++;
                data[i] %= 2;
            }
        }else if(k == 2) {
            int r = v + 1;
            int l = v - 1;
            while(l >= 1 && r <= N && data[l] == data[r]) {
                r++;
                l--;
                cnt++;
            }
            if (cnt > 0) {
                for (int i = v - cnt; i < v + cnt + 1; i++) {
                    data[i]++;
                    data[i] %= 2;
                }
            }else {
                data[v]++;
                data[v] %= 2;
            }
        }
    }
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        data = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        int P = Integer.parseInt(br.readLine());
        for (int t = 0; t < P; t++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            change(a, b);
        }

        for (int i = 1; i < N + 1; i++) {
            System.out.print(data[i] + " ");
            if (i % 20 == 0) System.out.println();
        }
    }
}