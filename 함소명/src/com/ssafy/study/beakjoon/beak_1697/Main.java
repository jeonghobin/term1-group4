package com.ssafy.study.beakjoon.beak_1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 숨바꼭질
 * 큐에 해당 위치를 넣어주고, 해당 숫자를 인덱스로 방문 체크.
 */
public class Main {

	static boolean[] check = new boolean[100001];// 100000까지 들어감.
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());// 수빈이 위치
		int M = Integer.parseInt(st.nextToken());// 동생 위치
		int[] arr = new int[100000];
		cnt = 0;

		if (N == M)
			System.out.println(0);
		else
			BFS(N, M);

	}

	private static void BFS(int N, int M) {
		Queue<Integer> Q = new LinkedList<>();

		Q.offer(N);
		check[N] = true;

		L: while (!Q.isEmpty()) {

			cnt++;

			int len = Q.size();
			for (int i = 0; i < len; i++) {
				int num = Q.poll();
				for (int j = 0; j < 3; j++) {
					int move = 0;
					if (j == 0)
						move = num + 1;
					if (j == 1)
						move = num - 1;
					if (j == 2)
						move = num * 2;

					if (move >= 0 && move <= 100000 && !check[move]) {
						check[move] = true;
						Q.offer(move);
					}
				}
				if (check[M]) {
					System.out.println(cnt);

					break L;
				}
			}
		}

	}
}
