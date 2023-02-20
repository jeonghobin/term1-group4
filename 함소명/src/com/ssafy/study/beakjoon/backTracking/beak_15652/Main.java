package com.ssafy.study.beakjoon.backTracking.beak_15652;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * N과 M (4)
 * 중복 조합에서 거르기
 */
public class Main {
	static int N;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		recursive(1, new int[M],0);
		bw.flush(); // 남아있는 데이터 모두 출력
		bw.close();
	}

	// k= index
	public static void recursive(int aIdx, int[] sel, int sIdx) throws IOException {
		if (sIdx == sel.length) {
			for (int i = 0; i < sel.length; i++) {
				bw.write(sel[i] + " ");
			}
			bw.newLine();

			return;
		}

		for (int i = aIdx; i <= N; i++) {
			sel[sIdx] = i;
			recursive(i, sel, sIdx + 1);
		}

	}

}
