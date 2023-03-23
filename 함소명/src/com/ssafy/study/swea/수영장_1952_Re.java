package com.ssafy.study.swea;

import java.io.*;
import java.util.*;

//1일, 1달, 3달, 1년 이용권 -> 이용계획 최소비용 -> 완탐/백트래킹
public class 수영장_1952_Re {
	static int[] fee;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {
			fee = new int[4];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				fee[i] = Integer.parseInt(st.nextToken());
			}

			int[] plan = new int[12];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}

			// 1일권으로만 fee[0] * plan[] 개수 모두 더하기;
			// 1달권으로만 fee[1] * MonthCnt(plan[] 비어 있지 않은 개수)
			// 3달권으로만 fee[2] * 3달이 연속된 경우의 수
			// 1년권 fee[3]*1
			// -> 역으로 조합해보기. - 일수

			// 초기는 모든 경우를 담을 수 있는 1년권
			min = fee[3] * 1;
			
			BackTracking(plan, 0, 0);
			System.out.println("#"+test_case+" "+min);
		}
	}

	private static void BackTracking(int[] plan, int idx, int price) {
		if (idx >= 12) {
			min = Math.min(min, price);
		
			return;
		}


		// 3달
		BackTracking(plan, idx + 3, price + fee[2]);

		// 1달
		BackTracking(plan, idx + 1, price + fee[1]);

		// 1일
		BackTracking(plan, idx+1, price + fee[0]*plan[idx]);

	}
}
