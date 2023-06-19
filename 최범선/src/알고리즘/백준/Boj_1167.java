package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1167 {
    static int N, max;
    static boolean[] v;
    static ArrayList<Pair>[] list;
    static class Pair{
        int end, cost;
        public Pair(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "end=" + end +
                    ", cost=" + cost +
                    '}';
        }
    }

    public static void dfs(int idx, int dis){
        max = Math.max(max, dis);

        for (int i = 0; i < list[idx].size(); i++) {
            Pair t = list[idx].get(i);
            int end = t.end;
            int cost = t.cost;
            if (v[end]) continue;
            v[end] = true;
            dfs(end, dis + cost);
            v[end] = false;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        v = new boolean[N + 1];
        int[] count = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        int start, end, cost;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()){
                end = Integer.parseInt(st.nextToken());
                if (end == -1) break;
                count[end]++;
                cost = Integer.parseInt(st.nextToken());
                list[start].add(new Pair(end, cost));
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < N + 1; i++) {
            min = Math.min(min, count[i]);
        }

        for (int i = 1; i < N + 1; i++) {
            if (count[i] != min) continue;
            v[i] = true;
            dfs(i, 0);
            v[i] = false;
        }
        System.out.println(max);

    }
}
