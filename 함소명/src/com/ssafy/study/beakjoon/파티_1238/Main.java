package com.ssafy.study.beakjoon.파티_1238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, X;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		// 초기화
		ArrayList<info>[] adj = new ArrayList[N + 1];// 집에서 파티장으로
		ArrayList<info>[] revadj = new ArrayList[N + 1];// 파티장에서 집으로
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
			revadj[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());

			adj[s].add(new info(e, t));
			revadj[e].add(new info(s, t));
		}

		// 다익스트라 알고리즘 사용
		int[] dist = dijkstra(adj);// 출발지 출발 최소거리 기록
		int[] revdist = dijkstra(revadj);// 파티장 출발 최소거리 기록
//
//		System.out.println(Arrays.toString(dist));
//		System.out.println(Arrays.toString(revdist));

		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, dist[i] + revdist[i]);
		}

		System.out.println(max);
	}

	private static int[] dijkstra(ArrayList<info>[] adj) {
		PriorityQueue<info> Q = new PriorityQueue<>();

		boolean[] v = new boolean[N + 1];
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		dist[X] = 0;
		Q.add(new info(X, 0));

		while (!Q.isEmpty()) {
			info p = Q.poll();// 가장 가까운거리(t)를 가졌다.

			if (!v[p.e]) {
				v[p.e] = true;

				for (info p2 : adj[p.e]) {
					if (dist[p2.e] < dist[p.e] + p2.t)
						continue;
					dist[p2.e] = dist[p.e] + p2.t;
					Q.add(new info(p2.e, dist[p2.e]));
				}
			}
		}

		return dist;
	}

	static class info implements Comparable<info> {
		int e, t;

		public info(int e, int t) {
			super();
			this.e = e;
			this.t = t;
		}

		@Override
		public String toString() {
			return "info [e=" + e + ", t=" + t + "]";
		}

		@Override
		public int compareTo(info o) {

			return Integer.compare(this.t, o.t);
		}

	}
}
