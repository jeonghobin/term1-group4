package com.ssafy.study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

/*
 * 마을에는 N명이 아는 사람이면 묶어서 하나의 무리라고한다. 몇개의 무리가 존재하는지?
 * 
 * 접근 -> 인접 리스트
 */
public class 창용마을무리의개수_7465_Re {
	static int N;
	static boolean v[];
	static ArrayList<Integer>[] list;

	// 서로소 집합
	static int[] parents;// idx = 사람 번호, value = 루트노드

	static class Point {
		int x, y = 0;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int cnt = 0;

			// 인접 리스트
//			v = new boolean[N + 1];
//			list = new ArrayList[N + 1];
//			for (int i = 0; i < N + 1; i++) {
//				list[i] = new ArrayList<Integer>();
//			}
//
//			for (int i = 0; i < M; i++) {
//				st = new StringTokenizer(br.readLine());
//				int A = Integer.parseInt(st.nextToken());
//				int B = Integer.parseInt(st.nextToken());
//
//				list[A].add(B);
//				list[B].add(A);
//			}
//
//			for (int i = 1; i <= N; i++) {
//				if (!v[i]) {
//					cnt++;
//					DFS(i);
//				}
//			}
//			
//			System.out.println("#" + test_case + " " + cnt);

			// 서로소 집합
			makeSet();

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());

				union(A, B);// 아는 사람들끼리 하나의 무리로 만들어주기
			}
			
			// hashset은 중복없이 들어가니까.
			HashSet<Integer> res = new HashSet<>();
			for (int i = 1; i < N+1; i++) {
				res.add(find(parents[i]));// 각 사람들의 대장 번호 넣어주기.
			}

			System.out.println("#" + test_case + " " + res.size());
		}
	}

	private static void DFS(int current) {
		v[current] = true;

		for (int num : list[current]) {
			if (!v[num]) {
				DFS(num);
			}
		}
	}

	// 누가 루트가 될지 모르니 각 원소 저장
	static void makeSet() {
		parents = new int[N+1];

		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

	// 원소(a)의 루트노드 찾아가기
	static int find(int a) {
		// 기저조건 : root 값이 자기 자신인 경우
		if (parents[a] == a)
			return a;// 자신이 루트 노드면 리턴

//		return find(parents[a]);//아니면 다시 찾기 
		return parents[a] = find(parents[a]); // 최상위 루트를 내 부모랑 바꿔준다. //passcompression 건너 뛰어탐.
	}

	// 마을 사람 2명을 하나의 무리로 합치기
	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot != bRoot)
			parents[bRoot] = aRoot;
	}
}
