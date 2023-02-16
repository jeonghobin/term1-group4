package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_6808 {

    static int[] a, b, temp;
    static boolean[] vv;
    static int w1, w2;


    public static void p(int cnt) {


        if (cnt >= 9) {
            int s1 = 0, s2 = 0;

            for (int i = 0; i < 9; i++) {
                if (temp[i] > a[i]) s1 += temp[i] + a[i];
                else if(temp[i] < a[i]) s2 += temp[i] + a[i];
            }
            if (s1 > s2) w1++;
            else if (s1 < s2) w2++;

            return;
        }

        for (int i = 0; i < b.length; i++) {
            if(vv[i]) continue;
            vv[i] = true;
            temp[cnt] = b[i];
            p(cnt + 1);
            vv[i] = false;
        }



    }



    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int t = 1; t < tc + 1; t++) {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());

            a = new int[9];
            b = new int[9];
            vv = new boolean[9];
            w1 = 0;
            w2 = 0;
            temp = new int[9];
            boolean[] v = new boolean[19];
            for (int i = 0; i < 9; i++) {
                int temp = Integer.parseInt(st.nextToken());
                a[i] = temp;
                v[temp] = true;
            }
            int idx = 0;
            for (int i = 1; i < 19; i++) {
                if (!v[i]) b[idx++] = i;
            }

            p(0);
            sb.append(w2).append(" ").append(w1).append("\n");
        }
        System.out.println(sb);

    }

}
