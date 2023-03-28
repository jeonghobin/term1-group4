package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_2644 {
    static int N, x, y;
    static ArrayList<Integer>[] list;
    static boolean flag;
    static boolean[] v;

    public static void dfs(int idx, int cnt){

        v[idx] = true;
        if(idx == y){
            flag = true;
            System.out.println(cnt);
            return;
        }

        for (int i = 0; i < list[idx].size(); i++) {
            if(!v[list[idx].get(i)]){
                dfs(list[idx].get(i), cnt + 1);
            }
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        v = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        dfs(x, 0);
        if(!flag) System.out.println(-1);
    }
}
