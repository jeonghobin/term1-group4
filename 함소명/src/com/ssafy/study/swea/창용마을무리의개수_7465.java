package com.ssafy.study.swea;

import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingDeque;

/*
 * 마을에는 N명이 아는 사람이면 묶어서 하나의 무리라고한다. 몇개의 무리가 존재하는지?
 * 
 * 접근 -> 인접 리스트
 */
public class 창용마을무리의개수_7465 {
	static int N;
	static boolean v[];
	static ArrayList<Integer>[] list;

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

			v = new boolean[N+1];
			list = new ArrayList[N + 1];
			for (int i = 0; i < N + 1; i++) {
				list[i] = new ArrayList<Integer>();
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());

				list[A].add(B);
				list[B].add(A);
			}

			int cnt = 0;
			for (int i = 1; i <= N; i++) {
				if (!v[i]) {
					cnt++;
					DFS(i);
				}
			}
			
			System.out.println("#"+test_case+" "+cnt);
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

}
