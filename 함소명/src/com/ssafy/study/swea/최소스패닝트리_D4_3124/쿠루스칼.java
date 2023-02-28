package com.ssafy.study.swea.최소스패닝트리_D4_3124;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 쿠루스칼 {
	static int V;
	static int[] parents;

	static class Edge implements Comparable<Edge> {
		int s, e, c;

		public Edge(int s, int e, int c) {
			super();
			this.s = s;
			this.e = e;
			this.c = c;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.c, o.c);
		}

		@Override
		public String toString() {
			return "Edge [s=" + s + ", e=" + e + ", c=" + c + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			ArrayList<Edge> edges = new ArrayList<>();
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				edges.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken())));
			}

			Collections.sort(edges);

			makeSet();

			int cnt = 0;
			long sum = 0;//간선 가중치 합
			for (int i = 0; i < edges.size(); i++) {
				Edge edge = edges.get(i);
				
				if (find(edge.s) != find(edge.e)) {
					union(edge.s, edge.e);
//					System.out.println(edge);
					
					cnt++;
					sum += edge.c;
					if (cnt == V - 1)
						break;
				}
			}

			System.out.println("#"+test_case+" "+sum);
		}
	}

	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot != bRoot)
			parents[bRoot] = aRoot;
	}

	private static int find(int c) {
		if (parents[c] == c)
			return c;
		return parents[c] = find(parents[c]);
	}

	private static void makeSet() {
		parents = new int[V + 1];

		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
	}

}
