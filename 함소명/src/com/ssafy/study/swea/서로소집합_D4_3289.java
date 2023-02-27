package com.ssafy.study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 
 */
public class 서로소집합_D4_3289 {
	static int N;
	static int[] parents;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			parents = new int[N + 1];
			for (int i = 0; i <= N; i++) {
				parents[i] = i;
			}

			System.out.print("#" + test_case + " ");
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int relation = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (relation == 0)
					union(a, b);// 집합을 합친다.
				else {
					int A = find(a);// 같은 집합에 포함되어있는지 확인.
					int B = find(b);// 같은 집합에 포함되어있는지 확인.
					if (A == B)
						System.out.print(1);
					else
						System.out.print(0);
				}
			}

			System.out.println();
		}

	}

	private static int find(int a) {
		if (parents[a] == a)
			return a;
		else
			return parents[a] = find(parents[a]);// 자신이 속한 집합의 대표자를 자신의 부모로 : path comopression
	}

	private static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		if (rootA != rootB)
			parents[rootB] = rootA;
	}

}
