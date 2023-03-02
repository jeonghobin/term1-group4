package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;




public class Boj_1753{

    static int V, E;
    static ArrayList<Node>[] list;
    static int[] d;
    static boolean[] v;

    static class Node implements Comparable<Node>{
        int end, cost;
        public Node(int end, int cost) {
            super();
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }

    }


    static void dijkstra(int start) {
        d[start] = 0;

        PriorityQueue<Node> q = new PriorityQueue<Node>();

        q.add(new Node(start, 0));

        while(!q.isEmpty()) {

            Node t = q.poll();
            if(v[t.end]) continue;
            v[t.end] = true;

            for (Node node : list[t.end]) {
                if(!v[node.end] && d[node.end] > d[t.end] + node.cost) {
                    d[node.end] = d[t.end] + node.cost;
                    q.add(new Node(node.end, d[node.end]));
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        list = new ArrayList[V + 1];
        v = new boolean[V + 1];
        d = new int[V + 1];

        Arrays.fill(d, Integer.MAX_VALUE);

        for(int i = 0; i < V + 1; i++) list[i] = new ArrayList<Node>();


        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[s].add(new Node(e, c));
        }


        dijkstra(start);

        for (int i = 1; i < V + 1; i++) {
            System.out.println(d[i] != Integer.MAX_VALUE ? d[i] : "INF");
        }


    }

}

