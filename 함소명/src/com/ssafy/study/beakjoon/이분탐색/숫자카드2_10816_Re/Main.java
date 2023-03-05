package com.ssafy.study.beakjoon.이분탐색.숫자카드2_10816_Re;

import java.io.*;
import java.util.*;

//HashMap사용
//이분 탐색 사용
//이분 탐색 풀어보고 싶으면 랜선 자르기 ㄱㄱ
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] Ncards;
	static int N;

	public static void main(String[] args) throws IOException {
//		HashMapSolve();

		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Ncards = new int[N];
		for (int i = 0; i < N; i++) {
			Ncards[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(Ncards);

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			int card = Integer.parseInt(st.nextToken());

			int cnt = maxIdx(card) - minIdx(card);

			bw.append(cnt + " ");
		}
		bw.flush();
		bw.close();
	}

	private static int maxIdx(int card) {
		int start = 0;
		int end = N;
		int mid = 0;

		while (start < end) {
			mid = (start + end) / 2;

			// 같으면 끝 인덱스까지 탐색 start++ -> 높은 인덱스의 값을 반환
			if (card < Ncards[mid]) {
				end = mid;
			} else
				start = mid + 1;
		}

		return start;
	}

	private static int minIdx(int card) {
		int start = 0;
		int end = N;
		int mid = 0;

		while (start < end) {
			mid = (start + end) / 2;

			// 같으면 끝 인덱스까지 탐색 start++ -> 높은 인덱스의 값을 반환
			if (card <= Ncards[mid]) {
				end = mid;
			} else
				start = mid + 1;
		}

		return start;
	}

	private static void HashMapSolve() throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<Integer, Integer> Ncards = new HashMap<>();
		for (int i = 0; i < N; i++) {
			int card = Integer.parseInt(st.nextToken());
			Ncards.put(card, Ncards.getOrDefault(card, 0) + 1);
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int card = Integer.parseInt(st.nextToken());
			bw.append(Ncards.getOrDefault(card, 0) + " ");
		}
		bw.flush();
		bw.close();
	}
}
