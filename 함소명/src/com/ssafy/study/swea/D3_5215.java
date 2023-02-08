package com.ssafy.study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//햄버거 다이어트
//조합
class Ingret {
	int cnt;
	int cal;

	public Ingret(int cnt, int cal) {
		super();
		this.cnt = cnt;
		this.cal = cal;
	}
}

public class D3_5215 {

	public static int N;
	public static int toCal;
	public static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			toCal = Integer.parseInt(st.nextToken());

			Ingret[] ig = new Ingret[N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int cnt = Integer.parseInt(st2.nextToken());
				int cal = Integer.parseInt(st2.nextToken());
				ig[i] = new Ingret(cnt, cal);
			}

			DFS(ig, 0, 0, 0);
			System.out.println("#" + test_case + " " + max);

		}
	}

	public static void DFS(Ingret[] arr, int k, int sumCnt, int sumCal) {
		if (sumCal > toCal)
			return;

		if (k == arr.length) {
			max = Math.max(sumCnt, max);
			return;
		}

		DFS(arr, k + 1, sumCnt + arr[k].cnt, sumCal + arr[k].cal);
		DFS(arr, k+1, sumCnt, sumCal);
	}
}
