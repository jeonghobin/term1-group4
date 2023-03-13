package com.ssafy.study.beakjoon.게리맨더링_17471_Re;

import java.io.*;
import java.util.*;

public class Main {
	static int N, min;
	static int[] area;
	static ArrayList<Integer>[] adj;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());// 구역 개수
		min = Integer.MAX_VALUE;

		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		area = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 지역에 인원 넣기
		for (int i = 1; i <= N; i++) {
			int population = Integer.parseInt(st.nextToken());
			area[i] = population;

			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st2.nextToken());// 인접한 구역의 수
			// 인접한 지역
			for (int j = 0; j < M; j++) {
				adj[i].add(Integer.parseInt(st2.nextToken()));
			}
		}

		// 선거구 2개로 나누기
		// 순서 있이 뽑으니까 순열
		// But -> 2개로 나눠야하는데 어떻게 나누지? 2개의 구역이니까 1, 2를 넣어 구분. 조합
		recursive(new int[N + 1], 1);
		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}

	private static void recursive(int[] sel, int k) {
		if (sel.length == k) {

			int areaA = 0;// A구역 인구 수
			int areaB = 0;
			int cntA = 0;// A구역 구역 수
			int cntB = 0;
			int idxA = 0;// A구역이 있는 인덱스 번호
			int idxB = 0;
			for (int i = 1; i <= N; i++) {
				if (sel[i] == 1) {
					idxA = i;
					cntA++;
					areaA += area[i];
				} else {
					idxB = i;
					cntB++;
					areaB += area[i];
				}
			}

			boolean isA = BFS(sel, 1, idxA, cntA);
			boolean isB = BFS(sel, 2, idxB, cntB);

			if (isA && isB) {
				int cha = Math.abs(areaA - areaB);
				min = Math.min(min, cha);
			}

			return;
		}

		sel[k] = 1;
		recursive(sel, k + 1);
		sel[k] = 2;
		recursive(sel, k + 1);

	}

	private static boolean BFS(int[] sel, int area, int idx, int totalcnt) {
		Queue<Integer> Q = new LinkedList<>();
		boolean[] v = new boolean[N + 1];
		Q.offer(idx);
		v[idx] = true;

		int cnt = 0;
		while (!Q.isEmpty()) {
			int p = Q.poll();

			if (p == 0)
				continue;

			cnt++;

			for (int i = 0; i < adj[p].size(); i++) {
				int num = adj[p].get(i);
				if (!v[num] && sel[num] == area) {
					v[num] = true;
					Q.offer(num);
				}
			}
		}

		if (cnt == totalcnt)
			return true;
		else
			return false;
	}

}
