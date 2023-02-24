package com.ssafy.study.beakjoon.ABCDE_13023_Re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
 * ABCDE
 * 모두 관계를 맺고 있는지 알아보는 문제! 인접리스트 활용
 */
public class Main {
	static int N;
	static int M;
	static ArrayList<Integer>[] adjList;// 인접리스트

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());// 사람 수
		M = Integer.parseInt(st.nextToken());// 관계 수
		adjList = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			adjList[from].add(to);
			adjList[to].add(from);
		}

//		for (ArrayList<Integer> list : adjList) {
//			System.out.println(list);
//		}

		for (int i = 0; i < N; i++) {
			DFS(i, new boolean[N], 1);
		}

		System.out.println(0);
	}

	private static void DFS(int current, boolean[] v, int d) {
		v[current] = true;
		if (d == 5) {
			System.out.println(1);
			System.exit(0);
		}
		// System.out.println((char) (current + 65));

		for (int num : adjList[current]) {
			if (!v[num]) {
				DFS(num, v, d + 1);
			}
		}
		v[current] = false;
	}

}
