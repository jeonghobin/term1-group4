package com.ssafy.study.beakjoon.최소스패닝트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int V;
    static int[] Node;
    static ArrayList<Point>[] adj;

    static class Point implements Comparable<Point> {
        int node;
        long cost;

        public Point(int start, long cost) {
            super();
            this.node = start;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point o) {
            // TODO Auto-generated method stub
            return Long.compare(this.cost, o.cost);
        }

        @Override
        public String toString() {
            return "Point [node=" + node + ", cost=" + cost + "]";
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        // 인접 리스트
        adj = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++) {
            adj[i] = new ArrayList<Point>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            adj[a].add(new Point(b, c));
            adj[b].add(new Point(a, c));
        }

        // 정점 배열, 방문 배열
        long minCnt = primPQ(new long[V + 1], new boolean[V + 1]);
      
        System.out.println(minCnt);
    }

    private static long primPQ(long[] Node, boolean[] v) {
        PriorityQueue<Point> Q = new PriorityQueue<>();

        Arrays.fill(Node, Long.MAX_VALUE);
        Node[0] = 0;

        Q.add(new Point(1, 0));
        long sum = 0;

        while (!Q.isEmpty()) {
            Point p = Q.poll();

            if (!v[p.node]) {
                v[p.node] = true;

                sum += p.cost;
            
                for (Point point : adj[p.node]) {
                    if (!v[point.node] && point.cost < Node[p.node]) {
                        Node[p.node] = point.cost;
                        Q.add(point);
                    }
                }

            }

        }
        
        System.out.println(Arrays.toString(Node));
        return sum;
    }

}