package com.ssafy.study.beakjoon.연결요소의개수_11724;

import java.io.*;
import java.util.*;

//백준 11724 연결 요소의 개수
public class Main {
	static int N;
	static ArrayList<Integer>[] adj;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}

		BFS();
	}

	private static void BFS() {
		Queue<Integer> Q = new LinkedList<>();
		boolean[] v = new boolean[N + 1];
		v[0] = true;
		int cnt = 0;

		for (int i = 1; i < adj.length; i++) {
			if (!v[i]) {
				Q.offer(i);
				cnt++;
			}

			while (!Q.isEmpty()) {
				int p = Q.poll();

				for (int j = 0; j < adj[p].size(); j++) {
					int num = adj[p].get(j);

					if (!v[num]) {
						Q.offer(num);
						v[num] = true;
					}
				}

			}
		}

		System.out.println(cnt);
	}
}