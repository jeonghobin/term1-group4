package com.ssafy.study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//햄버거 다이어트
// 정해진 칼로리 이하의 조합 중에서 민기가 가장 선호하는 햄버거를 조합
class Ingredient {
	int cnt;
	int cal;

	public Ingredient(int cnt, int cal) {
		super();
		this.cnt = cnt;
		this.cal = cal;
	}
}

public class D3_5215_Re {

	public static int N;
	public static int toCal;
	public static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			toCal = Integer.parseInt(st.nextToken());
			max= Integer.MIN_VALUE;

			Ingredient[] ig = new Ingredient[N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int cnt = Integer.parseInt(st2.nextToken());
				int cal = Integer.parseInt(st2.nextToken());
				ig[i] = new Ingredient(cnt, cal);
			}

			DFS(ig, 0, 0, 0);
//			DFS2(ig, new boolean[ig.length], 0, 0, 0);
			System.out.println("#" + test_case + " " + max);

		}
	}


	public static void DFS(Ingredient[] arr, int aIdx, int Ssum, int Csum) {
	    if (Csum > toCal) { // 현재 칼로리가 최대 칼로리를 초과하는 경우
	        return;
	    }

	    if (aIdx == arr.length) { // 모든 재료에 대한 선택이 끝난 경우
	        max = Math.max(max, Ssum);
	        return;
	    }

	    DFS(arr, aIdx + 1, Ssum + arr[aIdx].cnt, Csum + arr[aIdx].cal); // 해당 재료를 선택하는 경우
	    DFS(arr, aIdx + 1, Ssum, Csum); // 해당 재료를 선택하지 않는 경우
		//????
//		//최대 칼로리 이하의 경우에 대해서만 최대 점수를 구하는 문제가 아니라
//		//현재 누적된 칼로리와 선택한 재료들의 개수를 체크하면서 최대 칼로리 이하의 경우에 대해서만 최대 점수를 구할 수 있도록 구현
//		for (int i = aIdx; i < arr.length; i++) {
//			DFS(arr, i + 1, Ssum + arr[i].cnt, Csum + arr[i].cal);
//		}
	}


	// 부분집합
	public static void DFS2(Ingredient[] arr, boolean[] sel, int idx, int sumCnt, int sumCal) {
		if (sumCal > toCal)
			return;

		if (idx == arr.length) {
			for (int i  = 0; i < sel.length; i++) {
				if (sel[i])
					max = Math.max(sumCnt, max);
			}
			return;
		}

		sel[idx] = true;
		DFS2(arr, sel, idx + 1, sumCnt + arr[idx].cnt, sumCal + arr[idx].cal);
		sel[idx] = false;
		DFS2(arr, sel, idx + 1, sumCnt, sumCal);
	}

}
