package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_13023 {

    static int N;
    static ArrayList<Integer>[] list;
    static boolean v[];
    static boolean flag;

    public static void dfs(int start, int cnt){
        System.out.println(start + " " + cnt);

        if (cnt >= 5){
            flag = true;
            return;
        }
        for (int i = 0; i < list[start].size(); i++) {
            int t = list[start].get(i);
            if (!v[t]) {
                v[t] = true;
                dfs(t, cnt + 1);
                v[t] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        flag = false;
        v = new boolean[N];
        for (int i = 0; i < N; i++) {
            v[i] = true;
            dfs(i, 1);
            if(flag) break;
            Arrays.fill(v, false);
        }
        System.out.println(flag ? 1 : 0);
    }
}
