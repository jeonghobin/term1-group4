package com.ssafy.study.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ShotGame {
	static int N,max,sum;
	// 값을 담아줄 배열
	static int[] Balloon;
	// 터트린풍선을 표시할 방문배열
	static boolean[] v;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());
			max = Integer.MIN_VALUE;
			v = new boolean[N];
			Balloon = new int[N];
			sum=0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				Balloon[i] = Integer.parseInt(st.nextToken());
			}

			// 순열
			recursive(0);
			System.out.println("#"+testCase+" "+max);
		}

	}

	private static void recursive(int idx) {
		if (idx == N) {
			max = Math.max(max, sum);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!v[i]) {
				v[i] = true;
				// 현재 풍선을 터트린 점수
				int score = shot(i);
				sum+= score;
				recursive(idx + 1);
				sum-= score;
				v[i] = false;
			}
		}
	}

	private static int shot(int idx) {
		int l = idx - 1;
		int r = idx + 1;
		while (l >= 0) {
			if (!v[l])
				break;
			l--;
		}
		while (r < N) {
			if (!v[r])
				break;
			r++;
		}

		if(l<0&&r<N) return Balloon[r];
		if(l>=0&&r>=N) return Balloon[l];
		if(l>=0&&r<N) return Balloon[l]*Balloon[r];
		return Balloon[idx];
	}

}
