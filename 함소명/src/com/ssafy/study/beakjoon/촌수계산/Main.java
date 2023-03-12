package com.ssafy.study.beakjoon.촌수계산;

import java.io.*;
import java.util.*;

/*
 * BFS, DFS level을 체크할때는 반드시 각 요소마다 배열로든 객체로든 cnt를 주면서 돌리자.
 */

public class Main {
	static ArrayList<Integer>[] adj;
	static int dist[];// 촌수

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());// 사람 수
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());// a와 b의 관계
		int b = Integer.parseInt(st.nextToken());// a와 b의 관계
		boolean[] v = new boolean[N + 1];
		dist = new int[N + 1];
		adj = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			adj[i] = new ArrayList<Integer>();
		}

		int M = Integer.parseInt(br.readLine());// 관계 수

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			adj[num1].add(num2);
			adj[num2].add(num1);
		}

		Queue<Integer> Q = new LinkedList<>();
		Q.offer(a);
		dist[a] = 1;

		int result = -1;
		L: while (!Q.isEmpty()) {
			int p = Q.poll();

			for (int i = 0; i < adj[p].size(); i++) {
				int num = adj[p].get(i);

				if (num == b) {
					result = dist[p];
					break L;
				}

				if (dist[num] != 0)
					continue;

				dist[num] = dist[p] + 1;
				Q.offer(num);
			}
		}

		System.out.println(result);

	}

}
