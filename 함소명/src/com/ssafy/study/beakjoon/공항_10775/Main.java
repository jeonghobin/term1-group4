package com.ssafy.study.beakjoon.공항_10775;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 서로소 집합
 * 도킹 후 앞과 도킹해줘서 루트노드가 0이 될 때까지 반복한다.
 */
public class Main {
	static int N;
	static int cnt;
	static int[] parents;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		makeSet();

		for (int i = 0; i < M; i++) {
			int plane = Integer.parseInt(br.readLine());

			// 루트노드가 0이면 종료
			int zero = find(plane);
			if (zero == 0)
				break;
			else
				union(zero - 1, zero);// 루트 노드 한단계 아래 도킹

		}

		System.out.println(cnt);
	}

	private static void makeSet() {
		parents = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			parents[i] = i;
		}
	}

	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);

		if (pa != pb) {
			cnt++;
			parents[pb] = pa;
		}
	}

	private static int find(int plane) {
		if (parents[plane] == plane)
			return plane;
		return parents[plane] = find(parents[plane]);// compression
	}
}
