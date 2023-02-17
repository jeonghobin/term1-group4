package algo.bj.s2_2961;

import java.io.*;
import java.util.*;

/*
 * 도영이가 만든 맛있는 음식
 * 몇 개를 선택해서 쓸지 알 수 없음
 * -> 부분 집합
 */
public class Main {
	static long minimun;
	static long[] tasteAdd;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		long[] tasteMul = new long[N]; // 신 맛
		tasteAdd = new long[N]; // 쓴 맛

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			tasteMul[i] = Integer.parseInt(st.nextToken());
			tasteAdd[i] = Integer.parseInt(st.nextToken());
		}
		minimun = Long.MAX_VALUE;
		recursive(tasteMul, new boolean[N], 0);
		System.out.println(minimun);

	}

	private static void recursive(long[] tasteMul, boolean[] v, int idx) {
		// basis part
		if (idx == tasteMul.length) {
			int maxAdd = 0;
			int maxMul = 1;
			for (int i = 0; i < v.length; i++) {
				if (v[i] == true) {
					maxAdd += tasteAdd[i];
					maxMul *= tasteMul[i];
				}
			}
			if (maxAdd != 0) {
				if (Math.abs(maxAdd - maxMul) < minimun) {
					minimun = Math.abs(maxAdd - maxMul);
				}
			}

			return;

		}

		// inductive part
		v[idx] = true;
		recursive(tasteMul, v, idx + 1);

		v[idx] = false;
		recursive(tasteMul, v, idx + 1);
	}
}
