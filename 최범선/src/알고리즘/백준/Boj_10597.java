package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Boj_10597{

    static int size;
    static String ans;
    static boolean[] v;
    static String a;

    public static void dfs(int idx, int N, String ans) {

        if(idx >= size) {
            for (int i = 1; i <= N; i++) {
                if(!v[i]) return;
            }

            System.out.println(ans.trim());
            System.exit(0);

            return;
        }

        String t = a.substring(idx, idx + 1);
        int val = Integer.parseInt(t);

        if (!v[val]) {
            v[val] = true;
            dfs(idx + 1, N > val ? N : val, ans + " " + t);
            v[val] = false;
        }
        if (idx < size - 1) {
            t = a.substring(idx, idx + 2);
            val = Integer.parseInt(t);
            if(val < 51 && !v[val]) {
                v[val] = true;
                dfs(idx + 2, N > val ? N : val, ans + " " + t);
                v[val] = false;
            }
        }



    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        a = br.readLine();
        v = new boolean[51];
        size = a.length();

        dfs(0, 0, "");

    }

}