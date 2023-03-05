package com.ssafy.study.beakjoon.게리맨더링_17471_Re;

import java.io.*;
import java.util.*;

/*
 * 1~N개 선거구의 최소 인구 차이
 */
public class Main {

	static int N;
	static int[] population, Node;
	static ArrayList<Integer>[] adj;
	static int min = Integer.MAX_VALUE;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());// 구역 수

		population = new int[N + 1];
		adj = new ArrayList[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
			population[i] = Integer.parseInt(st.nextToken());// 구역 인구
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				adj[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		Node = new int[N + 1]; // 각 지역구가 속한 선거구 저장. 1 or 2
		select(1, new boolean[N + 1]); // 뽑을 수 있는 모든 지역구 뽑기

		if (min == Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(min);
	}

	// 부분집합 선거구 나누기
	public static void select(int k, boolean[] sel) {
		if (k == sel.length) { // 모든 지역 다 뽑았다면
			int area1 = 0;
			int area2 = 0;

			for (int i = 1; i < sel.length; i++) {
				if (Node[i] == 1)
					area1 += population[i];
				else
					area2 += population[i];
			}

			visited = new boolean[N + 1];
			int link = 0; // 연결된 지역들의 개수를 셈.
			for (int i = 1; i <= N; i++) {
				if (!visited[i]) {
					bfs(i, Node[i]);
					link++;
				}
			}

			// 지역이 2개뤄 나눠졌고, 2지역안에서 서로 연결되어 있다면 최소값 계산
			if (link == 2)
				min = Math.min(min, Math.abs(area1 - area2));

			return;
		}

		Node[k] = 1; // k지역 1번 선거구에 할당.
		select(k + 1, sel);

		Node[k] = 2; // k지역 2번 선거구에 할당.
		select(k + 1, sel);
	}

	public static void bfs(int idx, int num) {
		Queue<Integer> q = new LinkedList<>();
		visited[idx] = true;
		q.offer(idx);

		while (!q.isEmpty()) {
			int current = q.poll();

			for (int i = 0; i < adj[current].size(); i++) {
				int next = adj[current].get(i);
				if (Node[next] == num && !visited[next]) {
					q.offer(next);
					visited[next] = true;
				}
			}
		}
	}
}
