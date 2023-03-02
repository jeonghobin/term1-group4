package com.ssafy.study.beakjoon.최단경로_1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V, E;
	static ArrayList<Vertex>[] adj;
	static int[] Nodes;
	static boolean[] v;

	static class Vertex implements Comparable<Vertex> {
		int e, c;

		public Vertex(int e, int c) {
			super();
			this.e = e;
			this.c = c;
		}

		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.c, o.c);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		v = new boolean[V + 1];
		Nodes = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			Nodes[i] = i;
		}
		Arrays.fill(Nodes, Integer.MAX_VALUE);

		int start = Integer.parseInt(br.readLine());

		adj = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			adj[a].add(new Vertex(b, c));
		}

		PriorityQueue<Vertex> Q = new PriorityQueue<>();
		Q.add(new Vertex(start, 0));
		Nodes[start] = 0;

		while (!Q.isEmpty()) {
			Vertex p = Q.poll();
			int minIdx = p.e;// -1

			if (!v[minIdx]) {
				v[minIdx] = true;

				for (Vertex next : adj[minIdx]) {
					if (!v[next.e] && Nodes[next.e] > Nodes[minIdx] + next.c) {
						Nodes[next.e] = Nodes[minIdx] + next.c;
						Q.add(new Vertex(next.e, Nodes[minIdx] + next.c));
					}
				}
			}
		}
		
		for (int i = 1; i <= V; i++) {
			if(Nodes[i]==Integer.MAX_VALUE)
				System.out.println("INF");
			else 
				System.out.println(Nodes[i]);
		}
	}
}
