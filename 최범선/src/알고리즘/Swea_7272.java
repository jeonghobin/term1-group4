package 알고리즘;

import java.io.*;
import java.util.*;
public class Swea_7272 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] data = {1,2,0,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0};

        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t < tc + 1; t++) {
            st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            String a = st.nextToken();
            String b = st.nextToken();
            sb.append("#").append(t).append(" ");
            boolean flag = true;
            int max = Math.min(a.length(), b.length());
            if (max != a.length() || max != b.length()) {
                flag = false;
            }
            else {
                for (int i = 0; i < max; i++) {
                    if (data[a.charAt(i) -'A'] != data[b.charAt(i) -'A']) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {sb.append("SAME");}
            else sb.append("DIFF");
            System.out.println(sb);
        }
    }
}
