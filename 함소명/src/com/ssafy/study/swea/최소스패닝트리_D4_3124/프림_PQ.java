package com.ssafy.study.swea.최소스패닝트리_D4_3124;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class 프림_PQ {
	static int V;
	static ArrayList<Vertex>[] adj;

	static class Vertex implements Comparable<Vertex>{
		int e, c;

		Vertex(int e, int c) {
			this.e = e;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Vertex [e=" + e + ", c=" + c + "]";
		}

		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.c, o.c);
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			// 인접리스트
			adj = new ArrayList[V+1];
			for (int i = 1; i <= V; i++) {
				adj[i] = new ArrayList<Vertex>();
			}

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				adj[a].add(new Vertex(b, c));
				adj[b].add(new Vertex(a, c));
			}

			System.out.println("#"+test_case+" "+primPQ(new int[V + 1], new boolean[V + 1]));

		}

	}

	/*
	 * 정점 배열, 방문배열
	 */
	private static long primPQ(int[] Node, boolean[] v) {
		/***** 정점배열의 값을 무한대로 설정 *****/
		Arrays.fill(Node, Integer.MAX_VALUE);
		Node[0] = 0;
		
		long sum  = 0;
		PriorityQueue<Vertex> Q = new PriorityQueue<>();
		Q.add(new Vertex(1, 0));
		
		while (!Q.isEmpty()) {
			Vertex p = Q.poll();
			
			if (!v[p.e]) {
				v[p.e] = true;

				sum += p.c;

				for (Vertex next : adj[p.e]) {
					if (!v[next.e] && next.c < Node[next.e]) {
						Node[next.e] = next.c;
//						System.out.println(next);
						Q.add(next);
					}
				}
			}
		}
		
		return sum;
	}

}
