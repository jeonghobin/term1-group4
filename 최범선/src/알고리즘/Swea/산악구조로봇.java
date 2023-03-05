package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 산악구조로봇 {

    static int N;
    static ArrayList<Pair>[] p;
    static int[] dist;
    static int[][] data;
    public static class Pair implements Comparable<Pair>{
        int end, cost;
        public Pair(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.cost, o.cost);
        }
        @Override
        public String toString() {
            return "Pair{" +
                    "end=" + end +
                    ", cost=" + cost +
                    '}';
        }
    }

    public static void bfs(int start){

        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(0, data[0][0]));
        dist[start] = 0;

        while (!q.isEmpty()){
            Pair t = q.poll();
            int start_end = t.end;
            int start_cost = t.cost;

            for (int i = 0; i < p[start_end].size(); i++) {
                int to_end = p[start_end].get(i).end;
                int to_cost = p[start_end].get(i).cost;
                int cost = 0;
                if(start_cost < to_cost) cost = (to_cost - start_cost) * 2;
                else if(start_cost == to_cost) cost = 1;
                if(dist[to_end] > dist[start_end] + cost){
                    dist[to_end] = dist[start_end] + cost;
                    q.add(new Pair(to_end, to_cost));
                }

            }
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(st.nextToken());

        for (int t = 1; t < tc + 1; t++) {
            sb.append("#").append(t).append(" ");
            N = Integer.parseInt(br.readLine());

            p = new ArrayList[N * N];
            data = new int[N][N];
            dist = new int[N*N];
            Arrays.fill(dist, Integer.MAX_VALUE);

            for (int i = 0; i < N*N; i++) p[i] = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    data[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int idx = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(i-1>=0) p[idx].add(new Pair(idx-N, data[i-1][j]));
                    if(i+1<N) p[idx].add(new Pair(idx+N, data[i+1][j]));
                    if(j-1>=0) p[idx].add(new Pair(idx-1, data[i][j-1]));
                    if(j+1<N) p[idx].add(new Pair(idx+1, data[i][j+1]));
                    idx++;
                }
            }
            bfs(0);
            sb.append(dist[idx - 1]).append("\n");
        }
        System.out.println(sb);
    }
}
