package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_10282 {
    static int N, d, start;
    static ArrayList<Pair>[] list;
    static StringBuilder sb;

    static class Pair{
        int e, cost;
        public Pair(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }
    }

    public static void bfs(){

        Queue<Pair> q = new LinkedList<>();
        boolean[] v = new boolean[N + 1];
        int[] d = new int[N + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        v[start] = true;
        d[start] = 0;

        q.add(new Pair(start, 0));

        int cnt = 0, time = 0;
        while (!q.isEmpty()){
            Pair t = q.poll();
            int e = t.e;
            int cost = t.cost;

            for (int i = 0; i < list[e].size(); i++) {
                Pair temp = list[e].get(i);

                if (d[temp.e] > d[e] + temp.cost){
                    d[temp.e] = d[e] + temp.cost;
                    q.add(new Pair(temp.e, cost + temp.cost));
                }
            }
        }
        for (int i = 1; i < N + 1; i++) {
            if(d[i] != Integer.MAX_VALUE){
                cnt++;
                time = Math.max(time, d[i]);
            }
        }
        sb.append(cnt).append(" ").append(time).append("\n");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());
        for (int t = 1; t < tc + 1; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());

            list = new ArrayList[N + 1];
            for (int i = 0; i < N + 1; i++) {
                list[i] = new ArrayList<>();
            }

            int a,b,time;
            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                time = Integer.parseInt(st.nextToken());
                list[b].add(new Pair(a, time));
            }
            bfs();
        }
        System.out.println(sb);
    }
}
